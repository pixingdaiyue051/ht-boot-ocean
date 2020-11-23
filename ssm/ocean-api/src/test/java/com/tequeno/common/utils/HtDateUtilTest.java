package com.tequeno.common.utils;

import org.junit.Test;

import java.util.Arrays;

public class HtDateUtilTest {

    @Test
    public void test() {
        System.out.println(HtDateUtil.nowDate());
        System.out.println(HtDateUtil.nowTime());
        System.out.println(HtDateUtil.now());
        final long monthOffset = 0L;
        final int weekOffset = 0;
        Arrays.stream(HtDateUtil.currentMonth(false, monthOffset))
                .forEach(System.out::println);
        Arrays.stream(HtDateUtil.currentWeek(false, weekOffset))
                .forEach(System.out::println);
        Arrays.stream(HtDateUtil.currentMonth(true, monthOffset))
                .forEach(System.out::println);
        Arrays.stream(HtDateUtil.currentWeek(true, weekOffset))
                .forEach(System.out::println);
    }
}