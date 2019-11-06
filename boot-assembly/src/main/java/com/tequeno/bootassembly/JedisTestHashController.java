package com.tequeno.bootassembly;

import com.tequeno.common.constants.HtResultBinder;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.redis.JedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("test/jedis/hash")
public class JedisTestHashController {

    @Autowired
    private JedisCacheUtil cacheUtil;

    @RequestMapping("set")
    public HtResultBinder set(@RequestParam("key") String key,
                              @RequestParam("hashKey") String hashKey,
                              @RequestParam("hashValue") Object hashValue) {
        key = JedisKeyPrefixEnum.HTEST.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.hset(key, hashKey, hashValue));
    }

    @RequestMapping("setObject")
    public HtResultBinder set(@RequestParam("key") String key, @RequestBody Map<String, Object> map) {
        key = JedisKeyPrefixEnum.HTEST.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.hmset(key, map));
    }

    @RequestMapping("get")
    public HtResultBinder get(@RequestParam("key") String key, @RequestParam("hashKey") String hashKey) {
        key = JedisKeyPrefixEnum.HTEST.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.hget(key, hashKey));
    }

    @RequestMapping("getObject")
    public HtResultBinder getObject(@RequestParam("key") String key) {
        key = JedisKeyPrefixEnum.HTEST.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.hmget(key));
    }
}