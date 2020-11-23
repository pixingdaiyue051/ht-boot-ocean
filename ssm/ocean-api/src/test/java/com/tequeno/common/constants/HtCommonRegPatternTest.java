package com.tequeno.common.constants;

import com.tequeno.common.utils.HtCommonMethodUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class HtCommonRegPatternTest {

    @Test
    public void testPhone() {
        String phone = "13455237616";
        boolean matches = phone.matches(HtCommonRegPattern.REG_PHONE);
        assertTrue(matches);
    }

    @Test
    public void testEmail() {
        String email = "33277svvns@3wf.cn.com";
        boolean matches = email.matches(HtCommonRegPattern.REG_MAIL);
        assertTrue(matches);
    }
}