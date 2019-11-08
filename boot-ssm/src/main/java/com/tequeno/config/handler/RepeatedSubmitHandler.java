package com.tequeno.config.handler;

import com.tequeno.common.enums.HtCommonErrorEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.cache.JedisCacheUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Aspect
@Order(1)
public class RepeatedSubmitHandler {

    @Autowired
    private JedisCacheUtil cacheUtil;

    @Pointcut("@annotation(com.tequeno.config.handler.HtRepeatedSubmitAnno)")
    public void repeatedSubmitAspect() {
    }

    @Around("repeatedSubmitAspect() && @annotation(repeatedSubmitAnno)")
    public Object doAdviceAround(ProceedingJoinPoint joinPoint, HtRepeatedSubmitAnno repeatedSubmitAnno) throws Throwable {
        Signature s = joinPoint.getSignature();
        String key = JedisKeyPrefixEnum.LOCK.assemblyKey(String.format("%s.%s", s.getDeclaringTypeName(), s.getName()));
        String value = UUID.randomUUID().toString();
        boolean isGetLock = cacheUtil.tryLock(key, value, repeatedSubmitAnno.expireTime());
        if (isGetLock) {
            Object proceed = joinPoint.proceed();
//            cacheUtil.releaseLock(key, value);
            return proceed;
        }
        return HtResultInfoWrapper.fail(HtCommonErrorEnum.NOT_REPEATED_SUBMIT);
    }
}