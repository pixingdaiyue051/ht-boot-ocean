package com.tequeno.bootassembly;

import com.tequeno.constants.HtResultModel;
import com.tequeno.constants.HtResultWrapper;
import com.tequeno.utils.HtDateUtil;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
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
}
