package com.tequeno.config.redis;

import com.tequeno.common.constants.HtPropertyConstant;
import com.tequeno.common.constants.HtZeroOneConstant;
import com.tequeno.common.enums.HtSeqPrefixEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.enums.JedisLockTimeEnum;
import com.tequeno.common.utils.HtDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    private final static Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    /**
     * 超时时间需要大于0
     */
    private final static long ZERO = HtZeroOneConstant.ZERO_L;

    /**
     * 获得锁是否成功 1 成功 0 失败
     */
    private final static Long SUCCESS = HtZeroOneConstant.ONE_L;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return
     */
    public boolean expire(String key, long time) {
        try {
            check(key, time);
            redisTemplate.expire(key, time, TimeUnit.MILLISECONDS);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.expire调用失败", e);
            return false;
        }
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key
     * @return 时间(秒)
     */
    public long getExpire(String key) {
        try {
            check(key);
            return redisTemplate.getExpire(key, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            logger.debug("RedisUtil.getExpire调用失败", e);
            return ZERO;
        }
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) {
        try {
            check(key);
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            logger.debug("RedisUtil.hasKey调用失败", e);
            return false;
        }
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    public boolean del(String... key) {
        try {
            if (key != null && key.length > HtZeroOneConstant.ZERO_I) {
                if (key.length == HtZeroOneConstant.ONE_I) {
                    redisTemplate.delete(key[HtZeroOneConstant.ZERO_I]);
                } else {
                    redisTemplate.delete(CollectionUtils.arrayToList(key));
                }
            }
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.del调用失败", e);
            return false;
        }
    }

    /**
     * 删除缓存
     *
     * @param c
     * @return
     */
    public boolean del(Collection c) {
        try {
            if (!CollectionUtils.isEmpty(c)) {
                redisTemplate.delete(c);
            }
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.del调用失败", e);
            return false;
        }
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        try {
            check(key);
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            logger.debug("RedisUtil.get调用失败", e);
            return null;
        }
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public boolean set(String key, Object value) {
        try {
            check(key, value);
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.set调用失败", e);
            return false;
        }
    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0
     * @return true成功 false 失败
     */
    public boolean set(String key, Object value, long time) {
        try {
            check(key, value, time);
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.MILLISECONDS);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.set调用失败", e);
            return false;
        }
    }

    /**
     * 根据hashKey获取单一hash缓存
     *
     * @param key     键
     * @param hashKey hash键对应是map的key
     * @return 值
     */
    public Object hget(String key, String hashKey) {
        try {
            check(key, hashKey);
            return redisTemplate.opsForHash().get(key, hashKey);
        } catch (Exception e) {
            logger.debug("RedisUtil.hget调用失败", e);
            return null;
        }
    }

    /**
     * 获取key对应的所有hash缓存
     *
     * @param key 键
     * @return 当前key下存放的所有数据
     */
    public Map<String, Object> hmget(String key) {
        try {
            check(key);
            return redisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            logger.debug("RedisUtil.hmget调用失败", e);
            return null;
        }
    }

    /**
     * 将map整体存入hash表
     *
     * @param key 键
     * @param map 对应多个键值
     * @return true 成功 false 失败
     */
    public boolean hmset(String key, Map<String, Object> map) {
        try {
            check(key);
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.hmset调用失败", e);
            return false;
        }
    }

    /**
     * 将map整体存入hash表,并设置失效时间
     *
     * @param key  键
     * @param map  对应多个键值
     * @param time 时间(秒)
     * @return true成功 false失败
     */
    public boolean hmset(String key, Map<String, Object> map, long time) {
        try {
            check(key, time);
            redisTemplate.opsForHash().putAll(key, map);
            redisTemplate.expire(key, time, TimeUnit.MILLISECONDS);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.hmset调用失败", e);
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建
     *
     * @param key       键
     * @param hashKey   项
     * @param hashValue 值
     * @return true 成功 false失败
     */
    public boolean hset(String key, String hashKey, Object hashValue) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, hashValue);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.hset调用失败", e);
            return false;
        }
    }

    /**
     * 向一张hash表中放入数据,如果不存在将创建,并设置失效时间
     *
     * @param key       键
     * @param hashKey   项
     * @param hashValue 值
     * @param time      时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return true 成功 false失败
     */
    public boolean hset(String key, String hashKey, Object hashValue, long time) {
        try {
            check(key, hashKey, time);
            redisTemplate.opsForHash().put(key, hashKey, hashValue);
            redisTemplate.expire(key, time, TimeUnit.MILLISECONDS);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.hset调用失败", e);
            return false;
        }
    }

    /**
     * 删除hash表中的值
     *
     * @param key     键 不能为null
     * @param hashKey 项 可以使多个 不能为null
     */
    public boolean hdel(String key, String... hashKey) {
        try {
            check(key, hashKey);
            redisTemplate.opsForHash().delete(key, hashKey);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.hdel调用失败", e);
            return false;
        }
    }

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key     键 不能为null
     * @param hashKey 项 不能为null
     * @return true 存在 false不存在
     */
    public boolean hasHashKey(String key, String hashKey) {
        try {
            check(key, hashKey);
            return redisTemplate.opsForHash().hasKey(key, hashKey);
        } catch (Exception e) {
            logger.debug("RedisUtil.hasHashKey调用失败", e);
            return false;
        }
    }

    public boolean lpush(String key, Object... value) {
        try {
            check(key, value);
            redisTemplate.opsForList().leftPush(key, value);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.lpush调用失败", e);
            return false;
        }
    }

    public boolean lpushCollection(String key, Collection c) {
        try {
            check(key, c);
            redisTemplate.opsForList().leftPushAll(key, c);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.lpushCollection调用失败", e);
            return false;
        }
    }

    public boolean rpush(String key, Object... value) {
        try {
            check(key, value);
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.rpush调用失败", e);
            return false;
        }
    }

    public boolean rpushCollection(String key, Collection c) {
        try {
            check(key, c);
            redisTemplate.opsForList().rightPushAll(key, c);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.rpushCollection调用失败", e);
            return false;
        }
    }

    public boolean sadd(String key, Object... obj) {
        try {
            check(key, obj);
            redisTemplate.opsForSet().add(key, obj);
            return true;
        } catch (Exception e) {
            logger.debug("RedisUtil.sadd调用失败", e);
            return false;
        }
    }

    public Set smembers(String key) {
        try {
            check(key);
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            logger.debug("RedisUtil.smembers调用失败", e);
            return null;
        }
    }

    private void check(String key) {
        if (null == key) {
            throw new RuntimeException();
        }
    }

    private void check(String key, Object value) {
        if (null == key || null == value) {
            throw new RuntimeException();
        }
    }

    private void check(String key, long time) {
        if (null == key || ZERO > time) {
            throw new RuntimeException();
        }
    }

    private void check(String key, Object value, long time) {
        if (null == key || null == value || ZERO > time) {
            throw new RuntimeException();
        }
    }

//    public void sendMsg(String chanel, Object message) {
//        redisTemplate.convertAndSend(chanel, message);
//    }


    /**
     * 模糊匹配key并且删除
     * *匹配所有
     * ?单匹配
     *
     * @param pattern
     * @return
     */
    public long keysDel(String pattern) {
        try {
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
            DefaultRedisScript redisScript = new DefaultRedisScript<>(script, Long.class);
            Object result = redisTemplate.execute(redisScript, Collections.singletonList(pattern));
            return Long.valueOf(result.toString());
        } catch (Exception e) {
            logger.debug("RedisUtil.keysDel调用失败", e);
            return -1L;
        }
    }


    /**
     * 模糊匹配key返回key集合
     * *匹配所有
     * ?单匹配
     *
     * @param pattern
     * @return
     */
    public List keys(String pattern) {
        try {
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
            DefaultRedisScript redisScript = new DefaultRedisScript<>(script, List.class);
            List result = (List) redisTemplate.execute(redisScript, redisTemplate.getKeySerializer(), redisTemplate.getKeySerializer(), Collections.singletonList(pattern));
            return result;
        } catch (Exception e) {
            logger.debug("RedisUtil.keysDel调用失败", e);
            return null;
        }
    }

    public boolean tryLock(String lockKey, JedisLockTimeEnum lockTimeEnum) {
        lockKey = JedisKeyPrefixEnum.LOCK.assemblyKey(lockKey);
        return tryLock(lockKey, lockTimeEnum.getExpireTime(), lockTimeEnum.getRetryEvicTime(), lockTimeEnum.getEvicTime());
    }

    /**
     * 获取分布式锁
     *
     * @param lockKey    锁
     * @param expireTime 单位ms
     * @return 是否获取成功
     */
    public boolean tryLock(String lockKey, long expireTime) {
        try {
            lockKey = JedisKeyPrefixEnum.LOCK.assemblyKey(lockKey);
            String script = "local result = redis.call('setnx', KEYS[1], KEYS[1])\n" +
                    "if (result == 1) then\n" +
                    "    result = redis.call('pexpire', KEYS[1], ARGV[1])\n" +
                    "end\n" +
                    "return result";
            DefaultRedisScript redisScript = new DefaultRedisScript<>(script, Long.class);
            Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), expireTime);
            return SUCCESS.equals(result);
        } catch (Exception e) {
            logger.warn("尝试获取分布式锁-key[{}]异常", lockKey, e);
            return false;
        }
    }

    /**
     * 获取分布式锁
     *
     * @param lockKey       锁
     * @param expireTime    单位ms
     * @param retryEvicTime 重试间隔时间 单位ms
     * @param evicTime      最长重试等待时间 单位ms
     * @return 是否获取成功
     */
    private boolean tryLock(String lockKey, long expireTime, long retryEvicTime, long evicTime) {
        try {
            String script = "local result = redis.call('setnx', KEYS[1], KEYS[1])\n" +
                    "if (result == 1) then\n" +
                    "    result = redis.call('pexpire', KEYS[1], ARGV[1])\n" +
                    "end\n" +
                    "return result";
            DefaultRedisScript redisScript = new DefaultRedisScript<>(script, Long.class);
            List<String> keys = Collections.singletonList(lockKey);
            boolean isLocked;
            long startMillSecond = System.currentTimeMillis();
            do {
                Object result = redisTemplate.execute(redisScript, keys, expireTime);
                isLocked = SUCCESS.equals(result);
                // 已获得锁，无需等待
                if (isLocked) {
                    return true;
                }
                Thread.sleep(retryEvicTime);
                // 等待超时，获取锁失败
                if (System.currentTimeMillis() - startMillSecond > evicTime) {
                    return false;
                }
            } while (!isLocked);
        } catch (Exception e) {
            logger.warn("尝试获取分布式锁-key[{}]异常", lockKey, e);
        }
        return false;
    }

    /**
     * 生成全局唯一流水号
     *
     * @param htSeqPrefixEnum 流水号前缀
     * @return
     */
    public String tryGetOnlySequenceNum(HtSeqPrefixEnum htSeqPrefixEnum) {
        try {
            String now = HtDateUtil.nowDateNum();
            String key = JedisKeyPrefixEnum.SEQ.assemblyKey(htSeqPrefixEnum.getPrefix() + now);
            String script = "local result = redis.call('setnx', KEYS[1], ARGV[1])\n" +
                    "if(result == 1) then\n" +
                    "    redis.call('expire', KEYS[1], ARGV[2])\n" +
                    "    result = tonumber(ARGV[1])\n" +
                    "else\n" +
                    "    result = redis.call('incr', KEYS[1])\n" +
                    "end\n" +
                    "return result";
            DefaultRedisScript redisScript = new DefaultRedisScript<>(script, Long.class);
            Object result = redisTemplate.execute(redisScript, Collections.singletonList(key), Long.parseLong(now + HtPropertyConstant.SEQ_SUFFIX), HtPropertyConstant.ONE_DAY);
            return htSeqPrefixEnum.assemblySeq(result);
        } catch (Exception e) {
            logger.warn("尝试获取唯一序列号异常", e);
            return null;
        }
    }
}
