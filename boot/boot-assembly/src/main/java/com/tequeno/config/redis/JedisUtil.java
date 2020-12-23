package com.tequeno.config.redis;

import com.tequeno.common.constants.HtPropertyConstant;
import com.tequeno.common.enums.HtSeqPrefixEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.enums.JedisLockTimeEnum;
import com.tequeno.common.utils.HtDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Desription:
 * @Author: hexk
 */
@Component
public class JedisUtil {

    private final static Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis;

    private void fetchJedis() {
        if (null == jedis || !jedis.isConnected()) {
            jedis = jedisPool.getResource();
        }
    }

    private void closeJedis() {
        if (null != jedis) {
            jedis.disconnect();
            jedis.close();
        }
    }

    public boolean set(String key, String value) {
        return set(key, value, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT);
    }

    public boolean set(String key, String value, long expiredTime) {
        try {
            fetchJedis();
            String result = jedis.psetex(key, expiredTime, value);
            return JedisUtilHolder.OK.equals(result);
        } catch (Exception e) {
            logger.info("set(String,String,long[{}])异常:", expiredTime, e);
            return false;
        } finally {
            closeJedis();
        }
    }

    public String get(String key) {
        try {
            fetchJedis();
            return jedis.get(key);
        } catch (Exception e) {
            logger.info("get(String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    public Long delKeys(String... keys) {
        try {
            fetchJedis();
            return jedis.del(keys);
        } catch (Exception e) {
            logger.info("delKeys(String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    public Long delKeysByPattern(String pattern) {
        try {
            fetchJedis();
            Map<String, String> scriptMap = JedisUtilHolder.getScriptMap();
            String scriptSha = scriptMap.get("delKeysByPattern_script_sha");
            if (null == scriptSha || !jedis.scriptExists(scriptSha)) {
                String script = "local result = 0\n" +
                        "local scanResultIndex = 0\n" +
                        "while scanResultIndex ~= '0' do\n" +
                        "   local idx = tonumber(scanResultIndex)\n" +
                        "   local scanResult = redis.call('scan', idx, 'match', KEYS[1])\n" +
                        "   local scanResultTable = scanResult[2]\n" +
                        "   for k, v in pairs(scanResultTable) do\n" +
                        "       redis.call('del', v)\n" +
                        "   end\n" +
                        "   result = result + #scanResultTable\n" +
                        "   scanResultIndex = scanResult[1]\n" +
                        "end\n" +
                        "return result";
                scriptSha = jedis.scriptLoad(script);
                scriptMap.put("delKeysByPattern_script_sha", scriptSha);
            }
            Long result = (Long) jedis.evalsha(scriptSha, 1, pattern);
            return result;
        } catch (Exception e) {
            logger.info("delKeysByPattern(String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    public List keys(String pattern) {
        try {
            fetchJedis();
            Map<String, String> scriptMap = JedisUtilHolder.getScriptMap();
            String scriptSha = scriptMap.get("keys_script_sha");
            if (null == scriptSha || !jedis.scriptExists(scriptSha)) {
                String script = "local result = {}\n" +
                        "local scanResultIndex = 0\n" +
                        "while scanResultIndex ~= '0' do\n" +
                        "   local idx = tonumber(scanResultIndex)\n" +
                        "   local scanResult = redis.call('scan', idx, 'match', KEYS[1])\n" +
                        "   local scanResultTable = scanResult[2]\n" +
                        "   for k, v in pairs(scanResultTable) do\n" +
                        "      table.insert(result, v)\n" +
                        "   end\n" +
                        "   scanResultIndex = scanResult[1]\n" +
                        "end\n" +
                        "return result";
                scriptSha = jedis.scriptLoad(script);
                scriptMap.put("keys_script_sha", scriptSha);
            }
            ArrayList result = (ArrayList) jedis.evalsha(scriptSha, 1, pattern);
            return result;
        } catch (Exception e) {
            logger.info("keys(String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    public String tryGetOnlySequenceNum(HtSeqPrefixEnum htSeqPrefixEnum) {
        try {
            fetchJedis();
            String now = HtDateUtil.nowDateNum();
            String key = JedisKeyPrefixEnum.SEQ.assemblyKey(htSeqPrefixEnum.getPrefix() + now);
            Map<String, String> scriptMap = JedisUtilHolder.getScriptMap();
            String scriptSha = scriptMap.get("seq_script_sha");
            if (null == scriptSha || !jedis.scriptExists(scriptSha)) {
                String script = "local result = redis.call('setnx', KEYS[1], ARGV[1])\n" +
                        "if(result == 1) then\n" +
                        "    redis.call('pexpire', KEYS[1], ARGV[2])\n" +
                        "    result = tonumber(ARGV[1])\n" +
                        "else\n" +
                        "    result = redis.call('incr', KEYS[1])\n" +
                        "end\n" +
                        "return result";
                scriptSha = jedis.scriptLoad(script);
                scriptMap.put("seq_script_sha", scriptSha);
            }
            Object result = jedis.evalsha(scriptSha, 1, key, now + HtPropertyConstant.SEQ_SUFFIX, String.valueOf(HtPropertyConstant.ONE_DAY));
            return htSeqPrefixEnum.assemblySeq(result);
        } catch (Exception e) {
            logger.info("tryGetOnlySequenceNum(HtSeqPrefixEnum)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    public boolean tryLock(String lockKey, long expireTime) {
        try {
            fetchJedis();
            lockKey = JedisKeyPrefixEnum.LOCK.assemblyKey(lockKey);
            Map<String, String> scriptMap = JedisUtilHolder.getScriptMap();
            String scriptSha = scriptMap.get("lock_script_sha");
            if (null == scriptSha || !jedis.scriptExists(scriptSha)) {
                String script = "local result = redis.call('setnx', KEYS[1], KEYS[1])\n" +
                        "if (result == 1) then\n" +
                        "    result = redis.call('pexpire', KEYS[1], ARGV[1])\n" +
                        "end\n" +
                        "return result";
                scriptSha = jedis.scriptLoad(script);
                scriptMap.put("lock_script_sha", scriptSha);
            }
            Object result = jedis.evalsha(scriptSha, 1, lockKey, String.valueOf(expireTime));
            return JedisUtilHolder.ONE.equals(result);
        } catch (Exception e) {
            logger.info("tryLock(String,long)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    public boolean tryLock(String lockKey, JedisLockTimeEnum lockTimeEnum) {
        try {
            fetchJedis();
            lockKey = JedisKeyPrefixEnum.LOCK.assemblyKey(lockKey);
            Map<String, String> scriptMap = JedisUtilHolder.getScriptMap();
            String scriptSha = scriptMap.get("lock_script_sha");
            if (null == scriptSha || !jedis.scriptExists(scriptSha)) {
                String script = "local result = redis.call('setnx', KEYS[1], KEYS[1])\n" +
                        "if (result == 1) then\n" +
                        "    result = redis.call('pexpire', KEYS[1], ARGV[1])\n" +
                        "end\n" +
                        "return result";
                scriptSha = jedis.scriptLoad(script);
                scriptMap.put("lock_script_sha", scriptSha);
            }
            boolean isLocked;
            String expireTime = String.valueOf(lockTimeEnum.getExpireTime());
            long retryEvicTime = lockTimeEnum.getRetryEvicTime();
            long evicTime = lockTimeEnum.getEvicTime();
            long startMillSecond = System.currentTimeMillis();
            do {
                Object result = jedis.evalsha(scriptSha, 1, lockKey, expireTime);
                isLocked = JedisUtilHolder.ONE.equals(result);
                if (isLocked) {
                    logger.info("根据key[{}]获取锁成功", lockKey);
                    return true;
                }
                logger.info("尝试根据key[{}]获取锁失败,{}ms后重试", lockKey, retryEvicTime);
                Thread.sleep(retryEvicTime);
                if (System.currentTimeMillis() - startMillSecond > evicTime) {
                    logger.info("尝试根据key[{}]获取锁失败,已超出最大等待时间{}ms", lockKey, evicTime);
                    return false;
                }
            } while (!isLocked);
            return false;
        } catch (Exception e) {
            logger.info("tryLock(String,JedisLockTimeEnum)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    public boolean hset(String key, String field, String value) {
        return hset(key, field, value, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT);
    }

    public boolean hset(String key, String field, String value, long expiredTime) {
        try {
            fetchJedis();
            Transaction tx = jedis.multi();
            tx.hset(key, field, value);
            tx.pexpire(key, expiredTime);
            tx.exec();
            return true;
        } catch (Exception e) {
            logger.info("hset(long[{}])异常:", expiredTime, e);
            return false;
        } finally {
            closeJedis();
        }
    }

    public String hget(String key, String field) {
        try {
            fetchJedis();
            return jedis.hget(key, field);
        } catch (Exception e) {
            logger.info("hget(String,String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    public boolean hmset(String key, Map<String, String> fields) {
        return hmset(key, fields, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT);
    }

    public boolean hmset(String key, Map<String, String> fields, long expiredTime) {
        try {
            fetchJedis();
            Transaction tx = jedis.multi();
            tx.hmset(key, fields);
            tx.pexpire(key, expiredTime);
            tx.exec();
            return true;
        } catch (Exception e) {
            logger.info("hmset(String,Map,long[{}])异常:", expiredTime, e);
            return false;
        } finally {
            closeJedis();
        }
    }

    public List<String> hmget(String key, String... fields) {
        try {
            fetchJedis();
            if (null == fields || 0 == fields.length) {
                return jedis.hvals(key);
            }
            return jedis.hmget(key, fields);
        } catch (Exception e) {
            logger.info("hmget(String,String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    public Long hdel(String key, String... fields) {
        try {
            fetchJedis();
            if (null == fields || 0 == fields.length) {
                return jedis.del(key);
            }
            return jedis.hdel(key, fields);
        } catch (Exception e) {
            logger.info("hdel(String,String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    private static class JedisUtilHolder {

        private static JedisPool jedisPool;

        private static Map<String, String> scriptMap;

        private final static Long ONE = 1L;

        private final static String OK = "OK";

        private static JedisPool initPool() {
            if (null == jedisPool) {
                JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 10000, "276757");
            }
            return jedisPool;
        }

        private static Map<String, String> getScriptMap() {
            if (null == scriptMap) {
                scriptMap = new HashMap<>(11);
            }
            return scriptMap;
        }
    }

    public static void main(String[] args) {
//        JedisUtil jedisUtil = new JedisUtil();
//        jedisUtil.jedisPool = JedisUtilHolder.initPool();
//        boolean isOk = jedisUtil.tryLock("eed", JedisLockTimeEnum.QUICK);
//        System.out.println(isOk);
    }
}
