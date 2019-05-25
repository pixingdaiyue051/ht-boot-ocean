package com.tequeno.bootassembly;

import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.CommonResultUtil;
import com.tequeno.config.redis.JedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("jedis/hash")
public class JedisHashController {

    @Autowired
    private JedisCacheUtil cacheUtil;

    @PostMapping("set")
    public ResultBinder set(@RequestParam("key") String key,
                            @RequestParam("hashKey") String hashKey,
                            @RequestParam("hashValue") Object hashValue) {
        key = JedisKeyPrefixEnum.JEDIS.assemblyKey(key);
        return CommonResultUtil.success(cacheUtil.hset(key, hashKey, hashValue));
    }

    @PostMapping("setObject")
    public ResultBinder set(@RequestParam("key") String key, @RequestBody Map<Object, Object> map) {
        key = JedisKeyPrefixEnum.JEDIS.assemblyKey(key);
        return CommonResultUtil.success(cacheUtil.hmset(key, map));
    }

    @PostMapping("get")
    public ResultBinder get(@RequestParam("key") String key, @RequestParam("hashKey") Object hashKey) {
        key = JedisKeyPrefixEnum.JEDIS.assemblyKey(key);
        return CommonResultUtil.success(cacheUtil.hget(key, hashKey));
    }
}