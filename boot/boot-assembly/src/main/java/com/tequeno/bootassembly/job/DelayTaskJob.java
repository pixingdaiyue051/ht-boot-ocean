package com.tequeno.bootassembly.job;

import com.tequeno.config.redis.RedisUtil;
import com.tequeno.enums.JedisKeyPrefixEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Set;

//@Component
public class DelayTaskJob {

    private final static Logger logger = LoggerFactory.getLogger(DelayTaskJob.class);

    @Resource
    private ThreadPoolTaskExecutor pool;

    @Resource
    public RedisUtil redisUtil;

    @Resource
    public RedissonClient redisson;

    /**
     * 使用redisson delayedQueue+blockingQueue阻塞式获取任务
     */
    @PostConstruct
    public void redisson() {
        logger.info("redisson delay started");
        RBlockingQueue<String> blockingQueue = redisson.getBlockingQueue(JedisKeyPrefixEnum.QUEUE.getPrefix());

        pool.execute(() -> {
            while (true) {
                try {
                    String take = blockingQueue.take();
                    logger.info("redisson {}执行任务{}", Thread.currentThread().getName(), take);
                } catch (InterruptedException e) {
                    logger.error("redisson 获取队列任务异常", e);
                    break;
                }
            }
        });
    }

    @PreDestroy
    public void preDestroy() {
        logger.info("DelayTaskJob preDestroy");
        redisson.shutdown();
        pool.shutdown();
    }


    /**
     * 开启定时任务 扫描zset堆积的任务 不推荐
     */
//    @Scheduled(fixedRate = 5000)
    public void jedisZset() {
        logger.info("jedisZset delay...");
        // 获取jedis
        Jedis jedis = redisUtil.getJedis();

        long timeMillis = System.currentTimeMillis();
        Set<String> data = jedis.zrangeByScore(JedisKeyPrefixEnum.QUEUE.getPrefix(), 0, timeMillis);
        if (CollectionUtils.isNotEmpty(data)) {
            for (String item : data) {
                logger.info("zset {}执行任务{}", Thread.currentThread().getName(), item);
            }
            // 删除已经执行的任务
            jedis.zremrangeByScore(JedisKeyPrefixEnum.QUEUE.getPrefix(), 0, timeMillis);
        }
        // 关闭jedis
        redisUtil.closeJedis(jedis);
    }


}
