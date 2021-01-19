package com.tequeno.bootassembly;

import com.tequeno.config.RedisUtil;
import com.tequeno.constants.HtResultBinder;
import com.tequeno.utils.HtResultInfoWrapper;
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
    public HtResultBinder set(@RequestParam String key,
                              @RequestParam String hashKey,
                              @RequestParam Object hashValue) {
        return HtResultInfoWrapper.success(redisUtil.hset(key, hashKey, hashValue));
    }

    /**
     * @param key
     * @param map
     * @return
     */
    @RequestMapping("setObject")
    public HtResultBinder set(@RequestParam String key,
                              @RequestBody Map<String, Object> map) {
        return HtResultInfoWrapper.success(redisUtil.hmset(key, map));
    }

    /**
     * @param key
     * @param hashKey
     * @return
     */
    @RequestMapping("get")
    public HtResultBinder get(@RequestParam String key,
                              @RequestParam String hashKey) {
        return HtResultInfoWrapper.success(redisUtil.hget(key, hashKey));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("getObject")
    public HtResultBinder getObject(@RequestParam String key) {
        return HtResultInfoWrapper.success(redisUtil.hmget(key));
    }

    /**
     * @param key
     * @param hashKey
     * @return
     */
    @RequestMapping("del")
    public HtResultBinder delete(@RequestParam String key,
                                 @RequestParam String hashKey) {
        return HtResultInfoWrapper.success(redisUtil.hdel(key, hashKey));
    }

    /**
     * @param key
     * @param hashKey
     * @return
     */
    @RequestMapping("has")
    public HtResultBinder hasHash(@RequestParam String key,
                                  @RequestParam String hashKey) {
        return HtResultInfoWrapper.success(redisUtil.hasHashKey(key, hashKey));
    }
}
