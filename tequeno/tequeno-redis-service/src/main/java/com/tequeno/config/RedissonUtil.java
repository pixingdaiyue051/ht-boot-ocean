package com.tequeno.config;

import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class RedissonUtil {

    private final static Logger logger = LoggerFactory.getLogger(RedissonUtil.class);

    /**
     * 超时时间需要大于0
     */
    private final static long DEFAULT_TIME = 86400000;// 1days = 24*60*60


    @Resource
    private RedissonClient redissonClient;

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(ms)
     * @return
     */
    public void expire(String key, long time) {
        redissonClient.getBucket(key).expire(time, TimeUnit.MILLISECONDS);
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) {
        return redissonClient.getBucket(key).isExists();
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    public void del(String... key) {
        redissonClient.getKeys().delete(key);
    }

    /**
     * 删除缓存
     *
     * @param keyPattern key模式 ?单匹配 *模糊匹配
     */
    public void del(String keyPattern) {
        redissonClient.getKeys().deleteByPattern(keyPattern);
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public Object get(String key) {
        return redissonClient.getBucket(key).get();
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public void set(String key, Object value) {
        redissonClient.getBucket(key).set(value, DEFAULT_TIME, TimeUnit.MILLISECONDS);
    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(ms) time要大于0
     */
    public void set(String key, Object value, long time) {
        redissonClient.getBucket(key).set(value, time, TimeUnit.MILLISECONDS);
    }

    /**
     * 根据hashKey获取单一hash缓存
     *
     * @param key     键
     * @param hashKey hash键对应是map的key
     * @return 值
     */
    public Object hget(String key, String hashKey) {
        return redissonClient.getMap(key).get(hashKey);
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
        return redissonClient.getMap(key).fastPut(hashKey, hashValue);
    }

//    /**
//     * 获取key对应的所有hash缓存
//     *
//     * @param key 键
//     * @return 当前key下存放的所有数据
//     */
//    public Map<Object, Object> hmget(String key) {
//        return redissonClient.getMap(key).getAll(Collections.emptySet());
//    }


    /**
     * 将map整体存入hash表
     *
     * @param key 键
     * @param map 对应多个键值
     */
    public void hmset(String key, Map<String, Object> map) {
        redissonClient.getMap(key).putAll(map);
    }

}
