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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Aspect
@Order(0)
public class RepeatedSubmitHandler {

    private final static Logger logger = LoggerFactory.getLogger(RepeatedSubmitHandler.class);

    @Autowired
    private JedisCacheUtil cacheUtil;

    @Pointcut("@annotation(com.tequeno.config.handler.HtRepeatedSubmitAnno)")
    public void repeatedSubmitAspect() {
    }

    @Around("repeatedSubmitAspect() && @annotation(repeatedSubmitAnno)")
    public Object doAdviceAroundRepeatedSubmit(ProceedingJoinPoint joinPoint, HtRepeatedSubmitAnno repeatedSubmitAnno) throws Throwable {
        logger.debug("doAdviceAroundRepeatedSubmit");
        Signature s = joinPoint.getSignature();
        String key = JedisKeyPrefixEnum.LOCK.assemblyKey(s.getDeclaringTypeName(), s.getName());
        String value = UUID.randomUUID().toString();
        boolean isGetLock = cacheUtil.tryLock(key, value, repeatedSubmitAnno.expireTime());
        if (isGetLock) {
            // 立即释放锁
//            cacheUtil.releaseLock(key, value);
            return joinPoint.proceed();
        }
        return HtResultInfoWrapper.fail(HtCommonErrorEnum.NOT_REPEATED_SUBMIT);
    }
}