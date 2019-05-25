package com.tequeno.common.utils;

import java.util.Random;

public class CommonMethodUtil {

    private final static String SYMBOLS = "0123456789";

//    private final static String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String getNonceStr(int len) {
        final char[] nonceChars = new char[len];
        final Random random = new Random();
        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(random.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }
}