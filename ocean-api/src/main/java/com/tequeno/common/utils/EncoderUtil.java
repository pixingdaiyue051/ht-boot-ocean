package com.tequeno.common.utils;

import com.tequeno.common.enums.CommonCatchedEnum;

import java.security.MessageDigest;
import java.util.Base64;

public class EncoderUtil {

    private final static String charsetName = "UTF-8";

    private final static String ALGORITHM = "MD5";

    public static String md5Encode(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            byte[] encode = Base64.getEncoder().encode(md.digest(str.getBytes(charsetName)));
            String encode2 = new String(encode);
            return encode2;
        } catch (Exception e) {
            throw new CommonException(CommonCatchedEnum.PASSWORD_ENCODE_FAILED);
        }
    }
}