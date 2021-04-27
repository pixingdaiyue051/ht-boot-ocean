package com.tequeno.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HtEncoderUtil {

    private static final char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public final static String ALGORITHM_MD5 = "MD5";

    public final static String ALGORITHM_SHA256 = "SHA-256";

    public final static int ITER = 16;

    public static String md5Encode(String password, String salt) {
        try {
            password = encode(password, salt, ALGORITHM_MD5);
        } catch (Exception e) {
            return null;
        }
        return password;
    }

    public static String sha256Encode(String password, String salt) {
        try {
            password = encode(password, salt, ALGORITHM_SHA256);
        } catch (Exception e) {
            return null;
        }
        return password;
    }

    private static String encode(String password, String salt, String algorithmMd5) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithmMd5);
        if (salt != null) {
            digest.reset();
            digest.update(salt.getBytes());
        }
        byte[] hashed = digest.digest(password.getBytes());
        int iterations = ITER - 1;
        for (int i = 0; i < iterations; ++i) {
            digest.reset();
            hashed = digest.digest(hashed);
        }

        int l = hashed.length;
        char[] out = new char[l << 1];
        int i = 0;
        for (int var4 = 0; i < l; ++i) {
            out[var4++] = DIGITS[(240 & hashed[i]) >>> 4];
            out[var4++] = DIGITS[15 & hashed[i]];
        }
        return new String(out);
    }

    public static void main(String[] args) {
        System.out.println(md5Encode("123456", "123456"));
        System.out.println(sha256Encode("123456", "123456"));
    }
}