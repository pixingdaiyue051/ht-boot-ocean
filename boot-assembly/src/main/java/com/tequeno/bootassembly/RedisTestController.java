package com.tequeno.bootassembly;

import com.tequeno.common.constants.HtResultBinder;
import com.tequeno.common.enums.HtSeqPrefixEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.enums.JedisLockTimeEnum;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("test/redis")
public class RedisTestController {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * @param key
     * @param value
     * @return
     */
    @RequestMapping("set")
    public HtResultBinder set(@RequestParam("key") String key, @RequestParam("value") Object value) {
        key = JedisKeyPrefixEnum.TEST.assemblyKey(key);
        return HtResultInfoWrapper.success(redisUtil.set(key, value));
    }

    /**
     * @param map
     * @return
     */
    @RequestMapping("setObject")
    public HtResultBinder setObject(@RequestBody Map<String, Object> map) {
        map.forEach((k, v) -> {
            redisUtil.set(JedisKeyPrefixEnum.TEST.assemblyKey(k), v);
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
        return HtResultInfoWrapper.success(redisUtil.get(key));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("has/{key}")
    public HtResultBinder has(@PathVariable String key) {
        return HtResultInfoWrapper.success(redisUtil.hasKey(key));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("del/{key}")
    public HtResultBinder delete(@PathVariable String key) {
        return HtResultInfoWrapper.success(redisUtil.del(key));
    }

    /**
     * @param pattern
     * @return
     */
    @RequestMapping("delKey/{pattern}")
    public HtResultBinder deleteKeysWithPattern(@PathVariable String pattern) {
        return HtResultInfoWrapper.success(redisUtil.keysDel(pattern));
    }

    /**
     * @param key
     * @param time
     * @return
     */
    @RequestMapping("expire/{key}/{time}")
    public HtResultBinder expire(@PathVariable String key, @PathVariable long time) {
        return HtResultInfoWrapper.success(redisUtil.expire(key, time));
    }

//    /**
//     * @param chanel
//     * @param msg
//     * @return
//     */
//    @RequestMapping("send")
//    public HtResultBinder send(@RequestParam("chanel") String chanel, @RequestParam("msg") String msg) {
//        redisUtil.sendMsg(chanel, msg);
//        return HtResultInfoWrapper.success();
//    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("lock/{key}")
    public HtResultBinder lock(@PathVariable String key) {
        key = JedisKeyPrefixEnum.LOCK.assemblyKey(key);
        return HtResultInfoWrapper.success(redisUtil.tryLock(key, JedisLockTimeEnum.QUICK));
    }

    /**
     * @return
     */
    @RequestMapping("seq/{name}")
    public HtResultBinder seq(@PathVariable String name) {
        return HtResultInfoWrapper.success(redisUtil.tryGetOnlySequenceNum(HtSeqPrefixEnum.valueOf(name)));
    }

}