package com.tequeno.utils;

import org.apache.shiro.codec.CodecException;
import org.apache.shiro.crypto.UnknownAlgorithmException;
import org.apache.shiro.crypto.hash.SimpleHash;

public class HtLocalMethod {

    public final static String ALGORITHM_SHA256 = "SHA-256";

    public final static int ITER = 16;

    public static String shiroEncode(String password, String salt) {
        try {
            password = new SimpleHash(ALGORITHM_SHA256, password, salt, ITER).toString();
        } catch (CodecException e) {
            return null;
        } catch (UnknownAlgorithmException e) {
            return null;
        }
        return password;
    }
}
