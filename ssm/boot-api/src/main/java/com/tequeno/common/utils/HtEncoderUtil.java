package com.tequeno.common.utils;

import com.tequeno.common.constants.HtPropertyConstant;
import com.tequeno.common.enums.HtUserErrorEnum;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class HtEncoderUtil {

    public final static String CHARSET_UTF8 = HtPropertyConstant.CHARSET_UTF8;

    public final static String ALGORITHM_MD5 = HtPropertyConstant.ALGORITHM_MD5;

    public static String md5Encode(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_MD5);
            byte[] encode = Base64.getEncoder().encode(md.digest(str.getBytes(StandardCharsets.UTF_8)));
            String encode2 = new String(encode, StandardCharsets.UTF_8);
            return encode2;
        } catch (Exception e) {
            throw new HtCommonException(HtUserErrorEnum.PASSWORD_ENCODE_FAILED);
        }
    }
}