package com.tequeno.common.utils;

import com.tequeno.common.constants.HtPropertyConstant;

import java.util.Random;

public class HtCommonMethodUtil {

    public static String getNonceStr(int len) {
        final String symbols = HtPropertyConstant.NUMBER_STR;
        final char[] nonceChars = new char[len];
        final Random random = new Random();
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = symbols.charAt(random.nextInt(symbols.length()));
        }
        return new String(nonceChars);
    }
}