package com.tequeno.common.utils;

import com.tequeno.common.constants.HtCommonConstant;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class HtCommonMethodUtilTest {

    @Test
    public void getNonceStr() {
        String nonceStr = HtCommonMethodUtil.getNonceStr(HtCommonConstant.OPT_LENGTH);
        System.out.println(nonceStr);
        assertNotNull(nonceStr);
    }
}