package com.tequeno.config.cache;

import com.tequeno.common.constants.HtPropertyConstant;
import com.tequeno.common.constants.HtZeroOneConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class JedisCacheUtil {

    private final static Logger logger = LoggerFactory.getLogger(JedisCacheUtil.class);

    /**
     * 超时时间需要大于0
     */
    private final long ZERO = HtZeroOneConstant.ZERO_L;

    /**
     * 获得锁是否成功 1 成功 0 失败
     */
    private final Long SUCCESS = HtZeroOneConstant.ONE_L;

    /**
     * 获得分布式锁重试时间 默认1s 默认的超时时间3s(HtRepeatedSubmitAnno.waitTimeout) 所以默认可以尝试3次
     */
    private final long TIME_TO_RETRY = HtZeroOneConstant.ONE_LONG;

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
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.expire调用失败");
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
            return redisTemplate.getExpire(key, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.info("JedisCacheUtil.getExpire调用失败");
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
            logger.info("JedisCacheUtil.hasKey调用失败");
            return false;
        }
    }

    /**
     * 按模式匹配获得key
     * *匹配所有
     * ?单匹配
     *
     * @param pattern
     * @return
     */
    public Set keys(String pattern) {
        try {
            Set keys = redisTemplate.keys(pattern);
            return keys;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.keys调用失败");
            return null;
        }
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    public boolean del(String... key) {
        try {
            if (key != null && key.length > 0) {
                if (key.length == 0) {
                    redisTemplate.delete(key[0]);
                } else {
                    redisTemplate.delete(CollectionUtils.arrayToList(key));
                }
            }
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.del调用失败");
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
            logger.info("JedisCacheUtil.del调用失败");
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
            logger.info("JedisCacheUtil.get调用失败");
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
            redisTemplate.opsForValue().set(key, value, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.set调用失败");
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
            redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.set调用失败");
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
            logger.info("JedisCacheUtil.hget调用失败");
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
            logger.info("JedisCacheUtil.hmget调用失败");
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
            expire(key, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.hmset调用失败");
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
            expire(key, time);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.hmset调用失败");
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
            expire(key, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.hset调用失败");
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
            expire(key, time);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.hset调用失败");
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
            logger.info("JedisCacheUtil.hdel调用失败");
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
            logger.info("JedisCacheUtil.hasHashKey调用失败");
            return false;
        }
    }

    public boolean lpush(String key, Object... value) {
        try {
            check(key, value);
            redisTemplate.opsForList().leftPush(key, value);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.lpush调用失败");
            return false;
        }
    }

    public boolean lpushCollection(String key, Collection c) {
        try {
            check(key, c);
            redisTemplate.opsForList().leftPushAll(key, c);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.lpushCollection调用失败");
            return false;
        }
    }

    public boolean rpush(String key, Object... value) {
        try {
            check(key, value);
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.rpush调用失败");
            return false;
        }
    }

    public boolean rpushCollection(String key, Collection c) {
        try {
            check(key, c);
            redisTemplate.opsForList().rightPushAll(key, c);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.rpushCollection调用失败");
            return false;
        }
    }

    public boolean sadd(String key, Object... obj) {
        try {
            check(key, obj);
            redisTemplate.opsForSet().add(key, obj);
            return true;
        } catch (Exception e) {
            logger.info("JedisCacheUtil.sadd调用失败");
            return false;
        }
    }

    public Set smembers(String key) {
        try {
            check(key);
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            logger.info("JedisCacheUtil.smembers调用失败");
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

    public void sendMsg(String chanel, Object message) {
        redisTemplate.convertAndSend(chanel, message);
    }

    /**
     * 获取分布式锁
     *
     * @param lockKey     锁
     * @param requestId   请求标识
     * @param expireTime  单位秒
     * @param waitTimeout 单位毫秒
     * @return 是否获取成功
     */
    public boolean tryLock(String lockKey, String requestId, long expireTime, long waitTimeout) {
        // 当前时间
        long nanoTime = System.nanoTime();
        try {
            String script = "if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end end";
            int count = 1;
            do {
                RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
                Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), requestId, expireTime);
                if (SUCCESS.equals(result)) {
                    logger.info("尝试获取分布式锁-key[{}]requestId[{}]count[{}]成功", lockKey, requestId, count);
                    return true;
                }
                // 休眠后重试
                logger.info("重新尝试获取分布式锁-key[{}]requestId[{}]count[{}]", lockKey, requestId, count);
                Thread.sleep(TIME_TO_RETRY);
                count++;
            } while ((System.nanoTime() - nanoTime) < TimeUnit.MILLISECONDS.toNanos(waitTimeout));
        } catch (Exception e) {
            logger.error("尝试获取分布式锁-key[{}]requestId[{}]异常", lockKey, requestId, e);
        }
        return false;
    }

    /**
     * 释放锁
     *
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public boolean releaseLock(String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
        Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), requestId);
        return SUCCESS.equals(result);
    }
}