package com.tequeno.common.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommonMethodUtilTest {

    @Test
    public void getNonceStr() {
        String nonceStr = CommonMethodUtil.getNonceStr(4);
        System.out.println(nonceStr);
        assertNotNull(nonceStr);
    }
}