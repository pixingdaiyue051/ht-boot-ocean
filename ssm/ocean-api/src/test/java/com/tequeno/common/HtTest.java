package com.tequeno.common;

import com.tequeno.common.utils.HtResultInfoWrapper;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desription:
 * @Author: hexk
 */
public class HtTest {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();

        String str = "test";
        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                long l1 = System.currentTimeMillis();
                if (null != str) {
                    HtResultInfoWrapper.success(str);
                } else {
                    HtResultInfoWrapper.fail();
                }
                long l2 = System.currentTimeMillis();
                System.out.println("1---" + (l2 - l1));
            });
        }

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                long l1 = System.currentTimeMillis();
                Optional.ofNullable(str)
                        .map(HtResultInfoWrapper::success)
                        .orElse(HtResultInfoWrapper.fail());
                long l2 = System.currentTimeMillis();
                System.out.println("2---" + (l2 - l1));
            });
        }
        threadPool.shutdown();
    }
}
