package com.tequeno.bootassembly;

import com.tequeno.config.RedisUtil;
import com.tequeno.constants.HtPropertyConstant;
import com.tequeno.constants.HtResultBinder;
import com.tequeno.enums.JedisLockTimeEnum;
import com.tequeno.enums.JedisSeqPrefixEnum;
import com.tequeno.utils.HtResultInfoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public HtResultBinder set(@RequestParam String key,
                              @RequestParam Object value) {
        return HtResultInfoWrapper.success(redisUtil.set(key, value, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT));
    }

    /**
     * @param map
     * @return
     */
    @RequestMapping("setObject")
    public HtResultBinder setObject(@RequestBody Map<String, Object> map) {
        map.forEach((k, v) -> redisUtil.set(k, v, HtPropertyConstant.DEFAULT_REDIS_KEY_TIMEOUT));
        return HtResultInfoWrapper.success();
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("get")
    public HtResultBinder get(@RequestParam String key) {
        return HtResultInfoWrapper.success(redisUtil.get(key));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("has")
    public HtResultBinder has(@RequestParam String key) {
        return HtResultInfoWrapper.success(redisUtil.hasKey(key));
    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("del")
    public HtResultBinder del(@RequestParam String key) {
        return HtResultInfoWrapper.success(redisUtil.del(key));
    }

    /**
     * @param pattern
     * @return
     */
    @RequestMapping("delKey")
    public HtResultBinder deleteKeysWithPattern(@RequestParam String pattern) {
        return HtResultInfoWrapper.success(redisUtil.keysDel(pattern));
    }

//    /**
//     * @param pattern
//     * @return
//     */
//    @RequestMapping("keys")
//    public HtResultBinder matchKeysWithPattern(@RequestParam String pattern) {
//        return HtResultInfoWrapper.success(redisUtil.keys(pattern));
//    }

//    /**
//     * @param chanel
//     * @param msg
//     * @return
//     */
//    @RequestMapping("send")
//    public HtResultBinder send(@RequestParam String chanel,
//                               @RequestParam String msg) {
//        redisUtil.sendMsg(chanel, msg);
//        return HtResultInfoWrapper.success();
//    }

    /**
     * @param key
     * @return
     */
    @RequestMapping("lock")
    public HtResultBinder lock(@RequestParam String key) {
        return HtResultInfoWrapper.success(redisUtil.tryLock(key, JedisLockTimeEnum.QUICK));
    }

    /**
     * @return
     */
    @RequestMapping("seq")
    public HtResultBinder seq(@RequestParam String name) {
        return HtResultInfoWrapper.success(redisUtil.tryGetOnlySequenceNum(JedisSeqPrefixEnum.valueOf(name)));
    }

}
