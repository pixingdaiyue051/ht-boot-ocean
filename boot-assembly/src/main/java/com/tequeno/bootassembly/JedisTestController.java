package com.tequeno.bootassembly;

import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.redis.JedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("test/jedis")
public class JedisTestController {

    @Autowired
    private JedisCacheUtil cacheUtil;

    /**
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("set")
    public ResultBinder set(@RequestParam("key") String key, @RequestParam("value") Object value) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.set(key, value));
    }

    /**
     * @param map
     * @return
     */
    @RequestMapping("setObject")
    public ResultBinder setObject(@RequestBody Map<String, Object> map) {
        map.forEach((k, v) -> {
            cacheUtil.set(JedisKeyPrefixEnum.TEST.assemblyKey(k), v);
        });
        return HtResultInfoWrapper.success();
    }

    /**
     * @param pattern
     * @return
     */
    @RequestMapping("keys/{pattern}")
    public ResultBinder keys(@PathVariable String pattern) {
        return HtResultInfoWrapper.success(cacheUtil.keys(pattern));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("get/{key}")
    public ResultBinder get(@PathVariable String key) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.get(key));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("del/{key}")
    public ResultBinder delete(@PathVariable String key) {
        return HtResultInfoWrapper.success(cacheUtil.del(key));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("has/{key}")
    public ResultBinder has(@PathVariable String key) {
        return HtResultInfoWrapper.success(cacheUtil.hasKey(key));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("hasHash/{key}")
    public ResultBinder hasHash(@RequestParam String key, @RequestParam String hashKey) {
        return HtResultInfoWrapper.success(cacheUtil.hasHashKey(key, hashKey));
    }

    /**
     * @param key
     * @param time
     * @return
     */
    @RequestMapping("expire")
    public ResultBinder expire(@RequestParam("key") String key, @RequestParam("time") long time) {
        return HtResultInfoWrapper.success(cacheUtil.expire(key, time));
    }

    /**
     * @return
     */
    @RequestMapping("list")
    @SuppressWarnings("all")
    public ResultBinder list() {
        Map map1 = (Map) cacheUtil.keys(JedisKeyPrefixEnum.TEST.assemblyKey("*"))
                .stream()
                .collect(Collectors.toMap(key -> key, key -> cacheUtil.get(key.toString())));
        Map map2 = (Map) cacheUtil.keys(JedisKeyPrefixEnum.HTEST.assemblyKey("*"))
                .stream()
                .collect(Collectors.toMap(key -> key, key -> cacheUtil.hmget(key.toString())));
        map1.putAll(map2);
        return HtResultInfoWrapper.success(map1);
    }

    /**
     * @param chanel
     * @param msg
     * @return
     */
    @RequestMapping("send")
    public ResultBinder send(@RequestParam("chanel") String chanel, @RequestParam("msg") String msg) {
        cacheUtil.sendMsg(chanel, msg);
        return HtResultInfoWrapper.success();
    }
}