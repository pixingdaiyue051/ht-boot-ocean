package com.tequeno.config.handler;

import com.tequeno.common.enums.HtCommonErrorEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.HtCommonException;
import com.tequeno.config.cache.RedisUtil;
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
@Order(2)
public class RedisLockHandler {

    private final static Logger logger = LoggerFactory.getLogger(RedisLockHandler.class);

    @Autowired
    private RedisUtil redisUtil;

    @Pointcut("@annotation(com.tequeno.config.handler.HtRedisLockAnno)")
    public void redisLockAspect() {
    }

    @Around("redisLockAspect() && @annotation(redisLockAnno)")
    public Object doAdviceAroundRedisLock(ProceedingJoinPoint joinPoint, HtRedisLockAnno redisLockAnno) throws Throwable {
        logger.debug("doAdviceAroundRedisLock");
        Signature s = joinPoint.getSignature();
        String key = JedisKeyPrefixEnum.LOCK.assemblyKey(s.getDeclaringTypeName(), s.getName());
        boolean isLocked = redisUtil.tryLock(key, redisLockAnno.value());
        if (isLocked) {
            Object proceed;
            try {
                proceed = joinPoint.proceed();
            } catch (Throwable throwable) {
                throw throwable;
            } finally {
                // 最后一步一定要主动删key释放锁
                redisUtil.del(key);
            }
            return proceed;
        }
        throw new HtCommonException(HtCommonErrorEnum.LATER_TO_RETRY);
    }
}