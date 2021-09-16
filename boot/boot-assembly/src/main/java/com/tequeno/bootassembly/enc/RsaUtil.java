package com.tequeno.bootassembly.enc;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author raoyu
 * @Date 2020-07-31
 */
public class RsaUtil {


    /**
     * 加密算法AES
     */
    private static final String KEY_ALGORITHM = "RSA";

    /**
     * 算法名称/加密模式/数据填充方式
     * 默认：RSA/ECB/PKCS1Padding
     */
    private static final String ALGORITHMS = "RSA/ECB/PKCS1Padding";

    /**
     * Map获取公钥的key
     */
    private static final String PUBLIC_KEY = "publicKey";

    /**
     * Map获取公钥的key
     */
    private static final String JS_PUBLIC_KEY = "jsPublicKey";

    /**
     * Map获取私钥的key
     */
    private static final String PRIVATE_KEY = "privateKey";

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * RSA 位数 如果采用2048 上面最大加密和最大解密则须填写:  245 256
     */
    private static final int INITIALIZE_LENGTH = 1024;

    /**
     * 获取私钥
     */
    public static String getPrivateKey() {
        Key key = (Key) RsaHolder.keyMap.get(PRIVATE_KEY);
        return Base64.encodeBase64String(key.getEncoded());
    }

    /**
     * 获取公钥
     */
    public static String getPublicKey() {
        Key key = (Key) RsaHolder.keyMap.get(PUBLIC_KEY);
        return Base64.encodeBase64String(key.getEncoded());
    }

    /**
     * 获取前端公钥
     */
    public static String getJsPublicKey() {
        return RsaHolder.keyMap.get(JS_PUBLIC_KEY).toString();
    }

    /**
     * 添加前端公钥
     */
    public static void putJsPublicKey(String jsPublicKey) {
        RsaHolder.keyMap.put(JS_PUBLIC_KEY, jsPublicKey);
    }

    private static class RsaHolder {
        private final static Map<String, Object> keyMap = new HashMap<>(2);

        static {
            /**
             * 生成密钥对(公钥和私钥)
             */
            KeyPairGenerator keyPairGen = null;
            try {
                keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);

                keyPairGen.initialize(INITIALIZE_LENGTH);
                KeyPair keyPair = keyPairGen.generateKeyPair();
                RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
                RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
                //公钥
                keyMap.put(PUBLIC_KEY, publicKey);
                //私钥
                keyMap.put(PRIVATE_KEY, privateKey);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 公钥加密
     *
     * @param data      源数据
     * @param publicKey 公钥(前端提供)
     */
    public static String encrypt(String data, String publicKey) throws Exception {
        //base64格式的key字符串转Key对象
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);

        //设置加密、填充方式
        /*
            如需使用更多加密、填充方式，引入
            <dependency>
                <groupId>org.bouncycastle</groupId>
                <artifactId>bcprov-jdk16</artifactId>
                <version>1.46</version>
            </dependency>
            并改成
            Cipher cipher = Cipher.getInstance(ALGORITHMS ,new BouncyCastleProvider());
         */
        Cipher cipher = Cipher.getInstance(ALGORITHMS);
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        // 后端加密先转成普通字节
        byte[] bytes = data.getBytes();
        // 分段进行加密操作
        byte[] bytes1 = encryptAndDecryptOfSubsection(bytes, cipher, MAX_ENCRYPT_BLOCK);
        // 转成Base64输出(前端使用自己的私钥解码)
        return Base64.encodeBase64String(bytes1);
    }

    /**
     * 私钥解密
     *
     * @param encryptedData 已加密数据(前端使用后端的公钥加密的数据)
     * @return
     * @throws Exception
     */
    public static String decrypt(String encryptedData) throws Exception {
        //base64格式的key字符串转Key对象
        byte[] keyBytes = Base64.decodeBase64(getPrivateKey());
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);

        //设置加密、填充方式
        /*
            如需使用更多加密、填充方式，引入
            <dependency>
                <groupId>org.bouncycastle</groupId>
                <artifactId>bcprov-jdk16</artifactId>
                <version>1.46</version>
            </dependency>
            并改成
            Cipher cipher = Cipher.getInstance(ALGORITHMS ,new BouncyCastleProvider());
         */
        Cipher cipher = Cipher.getInstance(ALGORITHMS);
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        // 解码成base64字节
        byte[] bytes = Base64.decodeBase64(encryptedData);
        // 分段进行解密操作
        byte[] bytes1 = encryptAndDecryptOfSubsection(bytes, cipher, MAX_DECRYPT_BLOCK);
        return new String(bytes1);
    }

    /**
     * 分段进行加密、解密操作
     */
    private static byte[] encryptAndDecryptOfSubsection(byte[] data, Cipher cipher, int encryptBlock) throws Exception {
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > encryptBlock) {
                cache = cipher.doFinal(data, offSet, encryptBlock);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * encryptBlock;
        }
        byte[] toByteArray = out.toByteArray();
        out.close();
        return toByteArray;
    }

}
