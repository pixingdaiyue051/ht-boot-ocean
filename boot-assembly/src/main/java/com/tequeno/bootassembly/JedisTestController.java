package com.tequeno.bootassembly;

import com.tequeno.common.constants.HtResultBinder;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.enums.JedisLockTimeEnum;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.redis.JedisCacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    public HtResultBinder set(@RequestParam("key") String key, @RequestParam("value") Object value) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.set(key, value));
    }

    /**
     * @param map
     * @return
     */
    @RequestMapping("setObject")
    public HtResultBinder setObject(@RequestBody Map<String, Object> map) {
        map.forEach((k, v) -> {
            cacheUtil.set(JedisKeyPrefixEnum.TEST.assemblyKey(k), v);
        });
        return HtResultInfoWrapper.success();
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("get")
    public HtResultBinder get(@RequestParam("key") String key) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.get(key));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("has/{key}")
    public HtResultBinder has(@PathVariable String key) {
        return HtResultInfoWrapper.success(cacheUtil.hasKey(key));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("del/{key}")
    public HtResultBinder delete(@PathVariable String key) {
        return HtResultInfoWrapper.success(cacheUtil.del(key));
    }

    /**
     * @param pattern
     * @return
     */
    @RequestMapping("delKey/{pattern}")
    public HtResultBinder deleteKeysWithPattern(@PathVariable String pattern) {
        return HtResultInfoWrapper.success(cacheUtil.keysDel(pattern));
    }

    /**
     * @param key
     * @param time
     * @return
     */
    @RequestMapping("expire/{key}/{time}")
    public HtResultBinder expire(@PathVariable String key, @PathVariable long time) {
        return HtResultInfoWrapper.success(cacheUtil.expire(key, time));
    }

//    /**
//     * @param chanel
//     * @param msg
//     * @return
//     */
//    @RequestMapping("send")
//    public HtResultBinder send(@RequestParam("chanel") String chanel, @RequestParam("msg") String msg) {
//        cacheUtil.sendMsg(chanel, msg);
//        return HtResultInfoWrapper.success();
//    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("lock/{key}")
    public HtResultBinder lock(@PathVariable String key) {
        key = JedisKeyPrefixEnum.LOCK.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.tryLock(key, JedisLockTimeEnum.QUICK));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("release/{key}")
    public HtResultBinder release(@PathVariable String key) {
        key = JedisKeyPrefixEnum.LOCK.assemblyKey(key);
        return HtResultInfoWrapper.success(cacheUtil.releaseLock(key));
    }

}