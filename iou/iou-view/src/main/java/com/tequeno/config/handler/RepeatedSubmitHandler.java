package com.tequeno.config.handler;

import com.tequeno.config.cache.RedisUtil;
import com.tequeno.iou.anno.HtRepeatedSubmitAnno;
import com.tequeno.iou.enums.HtCommonErrorEnum;
import com.tequeno.iou.enums.JedisKeyPrefixEnum;
import com.tequeno.iou.utils.HtResultInfoWrapper;
import org.apache.shiro.SecurityUtils;
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

@Component
@Aspect
@Order(0)
public class RepeatedSubmitHandler {

    private final static Logger logger = LoggerFactory.getLogger(RepeatedSubmitHandler.class);

    @Autowired
    private RedisUtil redisUtil;

    @Pointcut("@annotation(com.tequeno.iou.anno.HtRepeatedSubmitAnno)")
    public void repeatedSubmitAspect() {
    }

    @Around("repeatedSubmitAspect() && @annotation(repeatedSubmitAnno)")
    public Object doAdviceAroundRepeatedSubmit(ProceedingJoinPoint joinPoint, HtRepeatedSubmitAnno repeatedSubmitAnno) throws Throwable {
        logger.debug("doAdviceAroundRepeatedSubmit");
        Signature s = joinPoint.getSignature();
        String key = JedisKeyPrefixEnum.LOCK.assemblyKey(SecurityUtils.getSubject().getSession().getId(), s.getDeclaringTypeName(), s.getName());
        boolean isLocked = redisUtil.tryLock(key, repeatedSubmitAnno.expireTime());
        if (isLocked) {
            return joinPoint.proceed();
        }
        return HtResultInfoWrapper.fail(HtCommonErrorEnum.DO_NOT_REPEAT_SUBMIT);
    }
}