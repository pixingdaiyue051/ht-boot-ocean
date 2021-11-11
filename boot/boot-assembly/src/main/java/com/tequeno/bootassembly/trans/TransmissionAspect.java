package com.tequeno.bootassembly.trans;

import com.alibaba.fastjson.JSON;
import com.tequeno.config.JedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * AES + RSA 加解密AOP处理
 */
@Component
@Aspect
public class TransmissionAspect {

    public final static String ENC_KEY = "enc_key";

    @Resource
    private JedisUtil jedisUtil;

    @Pointcut("@annotation(com.tequeno.bootassembly.trans.Encryption)")
    public void aspect() {
    }

    @Around("aspect() && @annotation(encryption)")
    public Object run(ProceedingJoinPoint joinPoint, Encryption encryption) throws Throwable {
        if (encryption.value().equals(Encryption.Type.HANDSHAKE)) {
            return this.after(joinPoint.proceed(this.pre(joinPoint)));
        }
        if (encryption.value().equals(Encryption.Type.ENCRYPT)) {
            return this.after(joinPoint.proceed());
        }
        if (encryption.value().equals(Encryption.Type.DECRYPT)) {
            return joinPoint.proceed(this.pre(joinPoint));
        }
        return joinPoint.proceed();
    }

    private Object[] pre(ProceedingJoinPoint joinPoint) throws Exception {
        long l1 = System.currentTimeMillis();

        Object[] args = joinPoint.getArgs();
        Map<String, String> req = (Map<String, String>) args[0];
        String cipher = req.get("cipher");
        String encryptData = req.get("data");
        String privateKey = jedisUtil.hashGet(ENC_KEY, RsaUtil.PRIVATE_KEY);
        String aesKey = RsaUtil.decrypt(cipher, privateKey);
        String decrypt = AesUtil.decrypt(encryptData, aesKey);

        Object o = JSON.parseObject(decrypt, Map.class);
        args[0] = o;

        long l2 = System.currentTimeMillis();
        System.out.printf("解密时长[%s]", l2 - l1);
        System.out.println();
        return args;
    }

    private Map<String, String> after(Object o) throws Throwable {
        long l1 = System.currentTimeMillis();

        Map<String, String> result = (Map<String, String>) o;

        String res1 = JSON.toJSONString(result.get("data"));
        //前端公钥
        String key = AesUtil.getKey();
        String data = AesUtil.encrypt(res1, key);
        String jpk = jedisUtil.hashGet(ENC_KEY, RsaUtil.JS_PUBLIC_KEY);
        String cipher = RsaUtil.encrypt(key, jpk);

        result.put("data", data);
        result.put("cipher", cipher);
        result.put("code", "0");

        long l2 = System.currentTimeMillis();
        System.out.printf("加密时长[%s]", l2 - l1);
        System.out.println();
        return result;
    }
}
