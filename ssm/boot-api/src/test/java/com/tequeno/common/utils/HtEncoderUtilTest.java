package com.tequeno.common.utils;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class HtEncoderUtilTest {

    @Test
    public void md5Encode() {
        String md5Encode;
        try {
            md5Encode = HtEncoderUtil.md5Encode("123456");
            System.out.println(md5Encode);
        } catch (Exception e) {
            md5Encode = null;
        }
        assertNotNull(md5Encode);
    }
}