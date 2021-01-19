package com.tequeno.bootassembly;

import com.tequeno.config.RedisUtil;
import com.tequeno.enums.JedisSeqPrefixEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootAssemblyApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Test
    public void contextLoads() {
//        for (int i = 0; i < 10; i++) {
//            executor.execute(() -> {
//            });
//        }
        String sequenceNum = redisUtil.tryGetOnlySequenceNum(JedisSeqPrefixEnum.TEST);
        System.out.println(sequenceNum);

    }

}
