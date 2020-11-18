package com.tequeno.utils;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class HtLocalMethodTest {

    @Test
    public void shiroEncode() {
        String salt = "aaa";
        String password = "123456";

        password = HtLocalMethod.shiroEncode(password, salt);
        System.out.println(password);
        assertNotNull(password);
    }
}