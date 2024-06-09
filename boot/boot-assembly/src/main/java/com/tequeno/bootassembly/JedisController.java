package com.tequeno.bootassembly;

import com.tequeno.config.redis.JedisUtil;
import com.tequeno.config.redis.RedisUtil;
import com.tequeno.constants.HtResultBinder;
import com.tequeno.utils.HtResultInfoWrapper;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Desription:
 * @Author: hexk
 */
@RestController
@RequestMapping("jedis")
public class JedisController {

    private final static Logger logger = LoggerFactory.getLogger(JedisController.class);

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private RedissonClient redisson;

    @RequestMapping("seq")
    public HtResultBinder seq() {
        long value = 24000;

//        JedisUtil jedisUtil = JedisUtil.getInstance();
//        Object out = jedisUtil.luaGetSequenceNum(value);

        Object out = redisUtil.luaGetSequenceNum(value);

        logger.info("序列号 {}", out);
        return HtResultInfoWrapper.success(out);
    }

    @RequestMapping("lock")
    public HtResultBinder lock() throws InterruptedException {
        String key = "test";
        long expire = 60000;

        // 1、jedis java原生
        JedisUtil jedisUtil = JedisUtil.getInstance();
        String token = String.valueOf(System.currentTimeMillis());
        boolean result = jedisUtil.luaTryLock(key, token, expire);

//        // 2、jedis spring托管
//        String token = String.valueOf(System.currentTimeMillis());
//        boolean result = redisUtil.luaTryLock(key, token, expire);

//        // 3、redisson lock
//        RLock lock = redisson.getLock(JedisKeyPrefixEnum.LOCK.assemblyKey(key));
//        boolean result = lock.tryLock(0, expire, TimeUnit.MILLISECONDS);

        if (result) {
            logger.info("加锁成功");
            return HtResultInfoWrapper.success();
        } else {
            logger.info("加锁失败");
            return HtResultInfoWrapper.fail();
        }
    }

}
