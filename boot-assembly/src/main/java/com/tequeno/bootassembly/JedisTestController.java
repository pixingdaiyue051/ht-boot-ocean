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
        String key = JedisKeyPrefixEnum.TEST.assemblyKey(map.get("key"));
        return HtResultInfoWrapper.success(cacheUtil.set(key, map.get("value")));
    }

    /**
     * @param pattern
     * @return
     */
    @GetMapping("keys/{pattern}")
    public ResultBinder keys(@PathVariable String pattern) {
        return HtResultInfoWrapper.success(cacheUtil.keys(pattern));
    }

    /**
     * @param key
     * @return
     */
    @GetMapping("get/{key}")
    public ResultBinder get(@PathVariable String key) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.hmget(key));
    }

    /**
     * @param key
     * @return
     */
    @GetMapping("del/{key}")
    public ResultBinder delete(@PathVariable String key) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.del(key));
    }

    /**
     * @param key
     * @param time
     * @return
     */
    @RequestMapping("expire")
    public ResultBinder expire(@RequestParam("key") String key, @RequestParam("time") long time) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.expire(key, time));
    }

    /**
     * @return
     */
    @RequestMapping("list")
    @SuppressWarnings("all")
    public ResultBinder list() {
        Object collect = cacheUtil.keys("*")
                .stream()
                .collect(Collectors.toMap(key -> key, key -> cacheUtil.get(key.toString())));
        return HtResultInfoWrapper.success(collect);
    }

    /**
     * @param chanel
     * @param msg
     * @return
     */
    @RequestMapping("send")
    public ResultBinder send(@RequestParam("chanel") String chanel, @RequestParam("msg") String msg) {
        cacheUtil.sendMsg(JedisKeyPrefixEnum.TEST.assemblyKey(chanel), msg);
        return HtResultInfoWrapper.success();
    }
}