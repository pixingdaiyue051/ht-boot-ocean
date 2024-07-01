package com.tequeno.bootassembly;

import com.tequeno.config.redis.JedisUtil;
import com.tequeno.config.redis.RedisUtil;
import com.tequeno.constants.HtResultModel;
import com.tequeno.constants.HtResultWrapper;
import com.tequeno.enums.JedisKeyPrefixEnum;
import com.tequeno.utils.HtDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

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

    @RequestMapping("seq")
    public HtResultModel seq() {
        long value = 24000;

//        JedisUtil jedisUtil = JedisUtil.getInstance();
//        Object out = jedisUtil.luaGetSequenceNum(value);

        Object out = redisUtil.luaGetSequenceNum(value);

        logger.info("序列号 {}", out);
        return HtResultWrapper.success(out);
    }

    @RequestMapping("lock")
    public HtResultModel lock() {
        String key = "test";
        long expire = 650000L;

        // 1、jedis java原生
        JedisUtil jedisUtil = JedisUtil.getInstance();
        String token = String.valueOf(System.currentTimeMillis());
        boolean result = jedisUtil.luaTryLock(key, token, expire);

//        // 2、jedis spring托管
//        String token = String.valueOf(System.currentTimeMillis());
//        boolean result = redisUtil.luaTryLock(key, token, expire);

        if (result) {
            logger.info("加锁成功");
            return HtResultWrapper.success();
        } else {
            logger.info("加锁失败");
            return HtResultWrapper.fail();
        }
    }

    @RequestMapping("delay")
    public HtResultModel delay(String value, long delay) {
        Jedis jedis = redisUtil.getJedis();
        jedis.zadd(JedisKeyPrefixEnum.QUEUE.getPrefix(), System.currentTimeMillis() + delay, value);
        redisUtil.closeJedis(jedis);
        return HtResultWrapper.success(HtDateUtil.now());
    }
}
