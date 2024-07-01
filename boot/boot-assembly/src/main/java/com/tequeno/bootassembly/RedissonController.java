package com.tequeno.bootassembly;

import com.tequeno.constants.HtResultModel;
import com.tequeno.constants.HtResultWrapper;
import com.tequeno.enums.JedisKeyPrefixEnum;
import com.tequeno.utils.HtDateUtil;
import org.redisson.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Desription:
 * @Author: hexk
 */
@RestController
@RequestMapping("redisson")
public class RedissonController {

    private final static Logger logger = LoggerFactory.getLogger(RedissonController.class);

    @Resource
    private RedissonClient redisson;

    @Resource
    private RDelayedQueue<String> delayedQueue;

    @RequestMapping("delay")
    public HtResultModel delay(String value, long delay) {
        delayedQueue.offer(value, delay, TimeUnit.MILLISECONDS);
        return HtResultWrapper.success(HtDateUtil.now());
    }

    @RequestMapping("lock")
    public HtResultModel lock(){
        String key = "test";
        long expire = 65000L;

        RLock lock = redisson.getLock(JedisKeyPrefixEnum.LOCK.assemblyKey(key));

        try {
            boolean result = lock.tryLock(0, expire, TimeUnit.MILLISECONDS);
            if (!result) {
                logger.info("加锁失败");
                return HtResultWrapper.fail();
            }
            logger.info("加锁成功");
            return HtResultWrapper.success();
        } catch (Exception e) {
            logger.info("加锁失败", e);
            return HtResultWrapper.fail(e.getMessage());
        }
    }

    @RequestMapping("map")
    public HtResultModel map() {
        RBatch batch = redisson.createBatch();
        RMapAsync<String, Integer> batchMap = batch.getMap("map:e11");
        batchMap.fastPutAsync("dq", 221);
        batchMap.fastPutAsync("dq1", 2212);
        batchMap.fastPutAsync("dq112", 221212);
        batchMap.expireAsync(10L, TimeUnit.MINUTES);
        batch.executeAsync();
        return HtResultWrapper.success(HtDateUtil.now());
    }


}
