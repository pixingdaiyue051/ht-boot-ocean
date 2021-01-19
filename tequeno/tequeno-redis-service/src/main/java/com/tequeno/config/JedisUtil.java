package com.tequeno.config;

import com.tequeno.constants.HtPropertyConstant;
import com.tequeno.enums.JedisKeyPrefixEnum;
import com.tequeno.enums.JedisLockTimeEnum;
import com.tequeno.enums.JedisSeqPrefixEnum;
import com.tequeno.utils.HtDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Desription:
 * @Author: hexk
 */
@Component
public class JedisUtil {

    private final static Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    @Autowired
    private JedisPool jedisPool;

    @Value("${file.lua}")
    private String profilesPath;

    private Jedis jedis;

    private void fetchJedis() {
        if (null == jedis || !jedis.isConnected()) {
            jedis = jedisPool.getResource();
        }
    }

    private void closeJedis() {
        if (null != jedis && jedis.isConnected()) {
            jedis.disconnect();
            jedis.close();
        }
    }

    //string 操作//////////////////////////////////////////////////////////////////////

    /**
     * string 设置key,使用默认超时时间
     *
     * @param key
     * @param value
     * @return 除非异常否则都是true
     */
    public boolean stringSetDefault(String key, String value) {
        return stringSet(key, value, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT);
    }

    /**
     * string 设置key,不超时
     *
     * @param key
     * @param value
     * @return 除非异常否则都是true
     */
    public boolean stringSetPersist(String key, String value) {
        try {
            fetchJedis();
            String result = jedis.set(key, value);
            return JedisUtilHolder.OK.equals(result);
        } catch (Exception e) {
            logger.info("stringSetPersist(String,String)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * string 设置key,指定超时时间
     *
     * @param key
     * @param value
     * @param expiredTime 单位ms
     * @return 除非异常否则都是true
     */
    public boolean stringSet(String key, String value, long expiredTime) {
        try {
            fetchJedis();
            String result = jedis.psetex(key, expiredTime, value);
            return JedisUtilHolder.OK.equals(result);
        } catch (Exception e) {
            logger.info("stringSet(String,String,long[{}])异常:", expiredTime, e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * string 同时设置多个key,value,使用默认超时时间
     *
     * @param stringMap
     * @return 除非异常否则都是true
     */
    public boolean stringSetDefault(Map<String, String> stringMap) {
        return stringSet(stringMap, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT);
    }

    /**
     * string 同时设置多个key,value,不超时
     *
     * @param stringMap
     * @return 除非异常否则都是true
     */
    public boolean stringSetPersist(Map<String, String> stringMap) {
        try {
            fetchJedis();
            Pipeline pipe = jedis.pipelined();
            pipe.multi();
            stringMap.forEach(pipe::set);
            pipe.exec();
            pipe.sync();
            return true;
        } catch (Exception e) {
            logger.info("stringSetPersist(Map)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * string 同时设置多个key,value使用指定超时时间
     *
     * @param stringMap
     * @param expiredTime 单位ms
     * @return 除非异常否则都是true
     */
    public boolean stringSet(Map<String, String> stringMap, long expiredTime) {
        try {
            fetchJedis();
            Pipeline pipe = jedis.pipelined();
            pipe.multi();
            stringMap.forEach((k, v) -> pipe.psetex(k, expiredTime, v));
            pipe.exec();
            pipe.sync();
            return true;
        } catch (Exception e) {
            logger.info("stringSet(Map,long[{}])异常:", expiredTime, e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * string 根据key返回value
     *
     * @param key
     * @return key不存在返回null, 异常返回null
     */
    public String stringGet(String key) {
        try {
            fetchJedis();
            return jedis.get(key);
        } catch (Exception e) {
            logger.info("stringGet(String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    /**
     * string 一次返回多个value,忽略不存在的key
     *
     * @param keyList
     * @return 如果所有key都不存在返回非null空集合, 异常返回null
     */
    public List<String> stringGet(List<String> keyList) {
        try {
            fetchJedis();
            Pipeline pipe = jedis.pipelined();
            keyList.forEach(pipe::get);
            List<Object> txResult = pipe.syncAndReturnAll();
            return txResult.parallelStream()
                    .filter(Objects::nonNull)
                    .map(Object::toString)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.info("stringGet(String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    /**
     * string 同时删除多个key
     *
     * @param keys
     * @return 除非异常否则都是true
     */
    public boolean stringDel(String... keys) {
        try {
            fetchJedis();
            Long result = jedis.del(keys);
            logger.info("redis删除{}个key", result);
            return true;
        } catch (Exception e) {
            logger.info("stringDel(String)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * string 同时删除多个key
     *
     * @param keyList
     * @return 除非异常否则都是true
     */
    public boolean stringDel(List<String> keyList) {
        try {
            fetchJedis();
            Pipeline pipe = jedis.pipelined();
            pipe.multi();
            keyList.forEach(pipe::del);
            pipe.exec();
            List<Object> txResult = pipe.syncAndReturnAll();
            long result = ((ArrayList) txResult.get(txResult.size() - 1)).parallelStream().mapToLong(r -> Long.valueOf(r.toString())).sum();
            logger.info("redis删除{}个key", result);
            return true;
        } catch (Exception e) {
            logger.info("stringDel(List)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    //hash 操作//////////////////////////////////////////////////////////////////////

    /**
     * hash 设置单个key的field,使用默认超时时间
     *
     * @param key
     * @param field
     * @param value
     * @return 除非异常否则都是true
     */
    public boolean hashSetDefault(String key, String field, String value) {
        return hashSet(key, field, value, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT);
    }

    /**
     * hash 设置单个key的field,不超时
     *
     * @param key
     * @param field
     * @param value
     * @return 除非异常否则都是true
     */
    public boolean hashSetPersist(String key, String field, String value) {
        try {
            fetchJedis();
            jedis.hset(key, field, value);
            return true;
        } catch (Exception e) {
            logger.info("hashSetPersist(String,String,String)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * hash 设置单个key的field,使用指定超时时间
     *
     * @param key
     * @param field
     * @param value
     * @param expiredTime 单位ms
     * @return 除非异常否则都是true
     */
    public boolean hashSet(String key, String field, String value, long expiredTime) {
        try {
            fetchJedis();
            Transaction tx = jedis.multi();
            tx.hset(key, field, value);
            tx.pexpire(key, expiredTime);
            tx.exec();
            return true;
        } catch (Exception e) {
            logger.info("hashSet(String,String,String,long[{}])异常:", expiredTime, e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * hash 设置同一个key的多个field,使用默认超时时间
     *
     * @param key
     * @param fields
     * @return 除非异常否则都是true
     */
    public boolean hashMultiSetDefault(String key, Map<String, String> fields) {
        return hashMultiSet(key, fields, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT);
    }

    /**
     * hash 设置同一个key的多个field,不超时
     *
     * @param key
     * @param fields
     * @return 除非异常否则都是true
     */
    public boolean hashMultiSetPersist(String key, Map<String, String> fields) {
        try {
            fetchJedis();
            jedis.hmset(key, fields);
            return true;
        } catch (Exception e) {
            logger.info("hashMultiSetPersist(String,Map)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * hash 设置同一个key的多个field,使用指定超时时间
     *
     * @param key
     * @param fields
     * @param expiredTime 单位ms
     * @return 除非异常否则都是true
     */
    public boolean hashMultiSet(String key, Map<String, String> fields, long expiredTime) {
        try {
            fetchJedis();
            Transaction tx = jedis.multi();
            tx.hmset(key, fields);
            tx.pexpire(key, expiredTime);
            tx.exec();
            return true;
        } catch (Exception e) {
            logger.info("hashMultiSet(String,Map,long[{}])异常:", expiredTime, e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * hash 返回指定field的value
     *
     * @param key
     * @param field
     * @return 异常返回null
     */
    public String hashGet(String key, String field) {
        try {
            fetchJedis();
            return jedis.hget(key, field);
        } catch (Exception e) {
            logger.info("hashGet(String,String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    /**
     * hash 返回多个field的value集合,如果只指定hashKey返回全部value结合
     *
     * @param key
     * @param fields
     * @return 异常返回null
     */
    public List<String> hashMultiGet(String key, String... fields) {
        try {
            fetchJedis();
            if (null == fields || 0 == fields.length) {
                return jedis.hvals(key);
            }
            List<String> txResult = jedis.hmget(key, fields);
            return txResult.parallelStream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.info("hashMultiGet(String,String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    /**
     * hash 返回多个field的value集合
     *
     * @param key
     * @param fieldList
     * @return 异常返回null
     */
    public List<String> hashMultiGet(String key, List<String> fieldList) {
        try {
            fetchJedis();
            Pipeline pipe = jedis.pipelined();
            fieldList.forEach(field -> pipe.hmget(key, field));
            List<Object> txResult = pipe.syncAndReturnAll();
            return txResult.parallelStream()
                    .map(obj -> ((ArrayList<String>) obj).get(0))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.info("hashMultiGet(String,List)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    /**
     * hash 删除指定field
     *
     * @param key
     * @param fields
     * @return 除非异常否则都是true
     */
    public boolean hashDel(String key, String... fields) {
        try {
            fetchJedis();
            Long result = jedis.hdel(key, fields);
            logger.info("redis删除hashKey[{}]内{}个field", key, result);
            return true;
        } catch (Exception e) {
            logger.info("hashDel(String,String)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * hash 删除指定field
     *
     * @param key
     * @param fieldList
     * @return 除非异常否则都是true
     */
    public boolean hashDel(String key, List<String> fieldList) {
        try {
            fetchJedis();
            Pipeline pipe = jedis.pipelined();
            pipe.multi();
            fieldList.forEach(filed -> pipe.hdel(key, filed));
            pipe.exec();
            List<Object> txResult = pipe.syncAndReturnAll();
            long result = ((ArrayList) txResult.get(txResult.size() - 1)).parallelStream().mapToLong(r -> Long.valueOf(r.toString())).sum();
            logger.info("redis删除hashKey[{}]内{}个field", key, result);
            return true;
        } catch (Exception e) {
            logger.info("hashDel(String,List)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    //lua 操作//////////////////////////////////////////////////////////////////////

    /**
     * 模式匹配key并删除key
     *
     * @param pattern ?单匹配 *全匹配 []范围匹配
     * @return 除非异常否则都是true
     */
    public boolean luaDelKeysByPattern(String pattern) {
        try {
            fetchJedis();
            Map<String, String> scriptMap = JedisUtilHolder.getScriptMap();
            String scriptSha = scriptMap.get(ScriptEnum.DEL_KEYS_PATTERN.getScriptName());
            if (null == scriptSha || !jedis.scriptExists(scriptSha)) {
                scriptSha = jedis.scriptLoad(loadScriptFromDisk(ScriptEnum.DEL_KEYS_PATTERN.getLuaFileName()));
                scriptMap.put(ScriptEnum.DEL_KEYS_PATTERN.getScriptName(), scriptSha);
            }
            Long result = (Long) jedis.evalsha(scriptSha, 1, pattern);
            logger.info("redis删除{}个key", result);
            return true;
        } catch (Exception e) {
            logger.info("luaDelKeysByPattern(String)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * 模式匹配key并说返回key集合
     *
     * @param pattern ?单匹配 *全匹配 []范围匹配
     * @return key集合, 异常返回null
     */
    public List<String> luaKeysByPattern(String pattern) {
        try {
            fetchJedis();
            Map<String, String> scriptMap = JedisUtilHolder.getScriptMap();
            String scriptSha = scriptMap.get(ScriptEnum.KEYS_PATTERN.getScriptName());
            if (null == scriptSha || !jedis.scriptExists(scriptSha)) {
                scriptSha = jedis.scriptLoad(loadScriptFromDisk(ScriptEnum.KEYS_PATTERN.getLuaFileName()));
                scriptMap.put(ScriptEnum.KEYS_PATTERN.getScriptName(), scriptSha);
            }
            return (ArrayList<String>) jedis.evalsha(scriptSha, 1, pattern);
        } catch (Exception e) {
            logger.info("luaKeysByPattern(String)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    /**
     * 根据时间(年月日),自增1序列
     *
     * @param key        序列key
     * @param expireTime 序列号超时时间
     * @return 自增后的序列号(自带前缀), 异常返回null
     */
    public Object luaGetSequenceNum(String key, long expireTime) {
        try {
            fetchJedis();
            String now = HtDateUtil.nowDateNum();
            key = JedisKeyPrefixEnum.SEQ.assemblyKey(key, now);
            Map<String, String> scriptMap = JedisUtilHolder.getScriptMap();
            String scriptSha = scriptMap.get(ScriptEnum.SEQUENCE_NUM.getScriptName());
            if (null == scriptSha || !jedis.scriptExists(scriptSha)) {
                scriptSha = jedis.scriptLoad(loadScriptFromDisk(ScriptEnum.SEQUENCE_NUM.getLuaFileName()));
                scriptMap.put(ScriptEnum.SEQUENCE_NUM.getScriptName(), scriptSha);
            }
            return jedis.evalsha(scriptSha, 1, key, now + HtPropertyConstant.SEQ_SUFFIX, String.valueOf(expireTime));
        } catch (Exception e) {
            logger.info("luaGetSequenceNum(JedisSeqPrefixEnum)异常:", e);
            return null;
        } finally {
            closeJedis();
        }
    }

    /**
     * 获取系统唯一序列号,超时时间为1天
     *
     * @param htSeqPrefixEnum 序列号前缀
     * @return 自增后的序列号(自带前缀), 异常返回null
     */
    public String luaGetSequenceNum(JedisSeqPrefixEnum htSeqPrefixEnum) {
        Object obj = luaGetSequenceNum(htSeqPrefixEnum.getPrefix(), HtPropertyConstant.ONE_DAY);
        if (null == obj) {
            return null;
        }
        return htSeqPrefixEnum.assemblySeq(obj);
    }

    /**
     * 分布式锁
     *
     * @param lockKey    锁的唯一key
     * @param token      随机生成token作为删除标志
     * @param expireTime 过期时间,单位ms
     * @return 是否成功加锁
     */
    public boolean luaTryLock(String lockKey, String token, long expireTime) {
        try {
            fetchJedis();
            lockKey = JedisKeyPrefixEnum.LOCK.assemblyKey(lockKey);
            Map<String, String> scriptMap = JedisUtilHolder.getScriptMap();
            String scriptSha = scriptMap.get(ScriptEnum.TRY_LOCK.getScriptName());
            if (null == scriptSha || !jedis.scriptExists(scriptSha)) {
                scriptSha = jedis.scriptLoad(loadScriptFromDisk(ScriptEnum.TRY_LOCK.getLuaFileName()));
                scriptMap.put(ScriptEnum.TRY_LOCK.getScriptName(), scriptSha);
            }
            Object result = jedis.evalsha(scriptSha, 1, lockKey, token, String.valueOf(expireTime));
            return JedisUtilHolder.ONE.equals(result);
        } catch (Exception e) {
            logger.info("luaTryLock(String,String,long)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * 分布式锁
     *
     * @param lockKey      锁的唯一key
     * @param token        随机生成token作为删除标志
     * @param lockTimeEnum 加锁策略
     * @return 是否成功加锁
     */
    public boolean luaTryLock(String lockKey, String token, JedisLockTimeEnum lockTimeEnum) {
        try {
            fetchJedis();
            lockKey = JedisKeyPrefixEnum.LOCK.assemblyKey(lockKey);
            Map<String, String> scriptMap = JedisUtilHolder.getScriptMap();
            String scriptSha = scriptMap.get(ScriptEnum.TRY_LOCK.getScriptName());
            if (null == scriptSha || !jedis.scriptExists(scriptSha)) {
                scriptSha = jedis.scriptLoad(loadScriptFromDisk(ScriptEnum.TRY_LOCK.getLuaFileName()));
                scriptMap.put(ScriptEnum.TRY_LOCK.getScriptName(), scriptSha);
            }
            boolean isLocked;
            String expireTime = String.valueOf(lockTimeEnum.getExpireTime());
            long retryEvicTime = lockTimeEnum.getRetryEvicTime();
            long evicTime = lockTimeEnum.getEvicTime();
            long startMillSecond = System.currentTimeMillis();
            do {
                Object result = jedis.evalsha(scriptSha, 1, lockKey, token, expireTime);
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
            logger.info("luaTryLock(String,String,JedisLockTimeEnum)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    /**
     * 释放分布式锁
     *
     * @param lockKey 锁的唯一key
     * @param token   随机生成token作为删除标志
     * @return 是否释放锁
     */
    public boolean luaReleaseLock(String lockKey, String token) {
        try {
            fetchJedis();
            lockKey = JedisKeyPrefixEnum.LOCK.assemblyKey(lockKey);
            Map<String, String> scriptMap = JedisUtilHolder.getScriptMap();
            String scriptSha = scriptMap.get(ScriptEnum.RELEASE_LOCK.getScriptName());
            if (null == scriptSha || !jedis.scriptExists(scriptSha)) {
                scriptSha = jedis.scriptLoad(loadScriptFromDisk(ScriptEnum.RELEASE_LOCK.getLuaFileName()));
                scriptMap.put(ScriptEnum.RELEASE_LOCK.getScriptName(), scriptSha);
            }
            Object result = jedis.evalsha(scriptSha, 1, lockKey, token);
            return JedisUtilHolder.ONE.equals(result);
        } catch (Exception e) {
            logger.info("luaTryLock(String,String)异常:", e);
            return false;
        } finally {
            closeJedis();
        }
    }

    private String loadScriptFromDisk(String luaFileName) throws Exception {
        FileChannel inChannel = FileChannel.open(Paths.get(profilesPath, luaFileName), StandardOpenOption.READ);
        MappedByteBuffer inMapper = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        byte[] b = new byte[inMapper.limit()];
        inMapper.get(b);
        String script = new String(b);
        inChannel.close();
        return script;
    }

    private enum ScriptEnum {
        TRY_LOCK("luaTryLock", "try_lock.lua"),
        RELEASE_LOCK("luaReleaseLock", "release_lock.lua"),
        SEQUENCE_NUM("luaGetSequenceNum", "sequence_num.lua"),
        KEYS_PATTERN("luaKeysByPattern", "keys_pattern.lua"),
        DEL_KEYS_PATTERN("luaDelKeysByPattern", "del_keys_pattern.lua"),
        ;
        private String scriptName;
        private String luaFileName;

        ScriptEnum(String scriptName, String luaFileName) {
            this.scriptName = scriptName;
            this.luaFileName = luaFileName;
        }

        public String getScriptName() {
            return scriptName;
        }

        public String getLuaFileName() {
            return luaFileName;
        }
    }

    private static class JedisUtilHolder {

        private static JedisPool jedisPool;

        private static Map<String, String> scriptMap;

        private final static Long ONE = 1L;

        private final static String OK = "OK";

        private static JedisPool initPool() {
            if (null == jedisPool) {
                try {
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    Yaml yaml = new Yaml();
                    InputStream inputStream = new FileInputStream("doc/assembly/application.yml");
                    Map map = yaml.loadAs(inputStream, Map.class);
                    map = (LinkedHashMap) (map.get("spring"));
                    map = (LinkedHashMap) (map.get("redis"));
                    String host = map.get("host").toString();
                    int database = (int) map.get("database");
                    int port = (int) map.get("port");
                    int timeout = (int) map.get("timeout");
                    jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null, database);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
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

    /**
     * 不依赖spring链接测试redis
     *
     * @param args
     */
    public static void main(String[] args) {
        JedisUtil jedisUtil = new JedisUtil();
        jedisUtil.jedisPool = JedisUtilHolder.initPool();
        jedisUtil.profilesPath = "doc/lua/";
        String lockKey = "waa";
        long l1 = System.currentTimeMillis();
        String token = String.valueOf(l1);
        boolean result = jedisUtil.luaTryLock(lockKey, token, JedisLockTimeEnum.QUICK);
//        boolean result = jedisUtil.luaReleaseLock(lockKey, token);
        long l2 = System.currentTimeMillis();
        logger.info("redis执行[{}]ms,[{}]", l2 - l1, result);
    }
}
