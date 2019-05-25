package com.tequeno.bootassembly;

import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.CommonResultUtil;
import com.tequeno.config.redis.JedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("jedis")
public class JedisController {

    @Autowired
    private JedisCacheUtil cacheUtil;

    @PostMapping("set")
    public ResultBinder set(@RequestParam("key") String key, @RequestParam("value") Object value) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return CommonResultUtil.success(cacheUtil.set(key, value));
    }

    @PostMapping("setObject")
    public ResultBinder setObject(@RequestBody Map<Object, Object> map) {
        String key = JedisKeyPrefixEnum.TEST.assemblyKey(map.get("key").toString());
        return CommonResultUtil.success(cacheUtil.set(key, map.get("value")));
    }

    @GetMapping("keys/{pattern}")
    public ResultBinder keys(@PathVariable String pattern) {
        return CommonResultUtil.success(cacheUtil.keys(pattern));
    }

    @GetMapping("get/{key}")
    public ResultBinder get(@PathVariable String key) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return CommonResultUtil.success(cacheUtil.hmget(key));
    }

    @GetMapping("del/{key}")
    public ResultBinder delete(@PathVariable String key) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return CommonResultUtil.success(cacheUtil.del(key));
    }

    @PostMapping("expire")
    public ResultBinder expire(@RequestParam("key") String key, @RequestParam("time") long time) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return CommonResultUtil.success(cacheUtil.expire(key, time));
    }

    /**
     * @return
     */
    @PostMapping("list")
    @SuppressWarnings("all")
    public ResultBinder list() {
        Object collect = cacheUtil.keys("*").stream()
                .collect(Collectors.toMap(key -> key, key -> cacheUtil.get(key.toString())));
        System.out.println(collect);
        return CommonResultUtil.success(collect);
    }
}