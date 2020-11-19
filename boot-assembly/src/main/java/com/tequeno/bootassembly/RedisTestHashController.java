package com.tequeno.bootassembly;

import com.tequeno.common.constants.HtResultBinder;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("test/redis/hash")
public class RedisTestHashController {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * @param key
     * @param hashKey
     * @param hashValue
     * @return
     */
    @RequestMapping("set")
    public HtResultBinder set(@RequestParam("key") String key,
                              @RequestParam("hashKey") String hashKey,
                              @RequestParam("hashValue") Object hashValue) {
        key = JedisKeyPrefixEnum.HTEST.assemblyKey(key);
        return HtResultInfoWrapper.success(redisUtil.hset(key, hashKey, hashValue));
    }

    /**
     * @param key
     * @param map
     * @return
     */
    @RequestMapping("setObject")
    public HtResultBinder set(@RequestParam("key") String key, @RequestBody Map<String, Object> map) {
        key = JedisKeyPrefixEnum.HTEST.assemblyKey(key);
        return HtResultInfoWrapper.success(redisUtil.hmset(key, map));
    }

    /**
     * @param key
     * @param hashKey
     * @return
     */
    @RequestMapping("get")
    public HtResultBinder get(@RequestParam("key") String key, @RequestParam("hashKey") String hashKey) {
        key = JedisKeyPrefixEnum.HTEST.assemblyKey(key);
        return HtResultInfoWrapper.success(redisUtil.hget(key, hashKey));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("getObject")
    public HtResultBinder getObject(@RequestParam("key") String key) {
        key = JedisKeyPrefixEnum.HTEST.assemblyKey(key);
        return HtResultInfoWrapper.success(redisUtil.hmget(key));
    }

    /**
     * @param key
     * @param hashKey
     * @return
     */
    @RequestMapping("del")
    public HtResultBinder delete(@RequestParam("key") String key, @RequestParam("hashKey") String hashKey) {
        key = JedisKeyPrefixEnum.HTEST.assemblyKey(key);
        return HtResultInfoWrapper.success(redisUtil.hdel(key, hashKey));
    }

    /**
     * @param key
     * @param hashKey
     * @return
     */
    @RequestMapping("has")
    public HtResultBinder hasHash(@RequestParam("key") String key, @RequestParam("hashKey") String hashKey) {
        key = JedisKeyPrefixEnum.HTEST.assemblyKey(key);
        return HtResultInfoWrapper.success(redisUtil.hasHashKey(key, hashKey));
    }
}