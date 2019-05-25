package com.tequeno.common.utils;

import org.junit.Test;

import java.util.Arrays;

public class DateUtilTest {

    @Test
    public void test() {
        System.out.println(DateUtil.nowDate());
        System.out.println(DateUtil.nowTime());
        System.out.println(DateUtil.now());
        final long monthOffset = 0L;
        final int weekOffset = 0;
        Arrays.stream(DateUtil.currentMonth(false, monthOffset))
                .forEach(System.out::println);
        Arrays.stream(DateUtil.currentWeek(false, weekOffset))
                .forEach(System.out::println);
        Arrays.stream(DateUtil.currentMonth(true, monthOffset))
                .forEach(System.out::println);
        Arrays.stream(DateUtil.currentWeek(true, weekOffset))
                .forEach(System.out::println);
    }
}