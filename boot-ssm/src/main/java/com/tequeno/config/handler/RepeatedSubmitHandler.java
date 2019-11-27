package com.tequeno.config.handler;

import com.tequeno.common.enums.HtCommonErrorEnum;
import com.tequeno.common.enums.JedisKeyPrefixEnum;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.cache.JedisCacheUtil;
import com.tequeno.config.mq.activemq.JmsScheduledPublisher;
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

    @Autowired
    private JmsScheduledPublisher scheduledPublisher;

    @Pointcut("@annotation(com.tequeno.config.handler.HtRepeatedSubmitAnno)")
    public void repeatedSubmitAspect() {
    }

    @Around("repeatedSubmitAspect() && @annotation(repeatedSubmitAnno)")
    public Object doAdviceAround(ProceedingJoinPoint joinPoint, HtRepeatedSubmitAnno repeatedSubmitAnno) throws Throwable {
        Signature s = joinPoint.getSignature();
        String key = JedisKeyPrefixEnum.LOCK.assemblyKey(s.getDeclaringTypeName(), s.getName());
        String value = UUID.randomUUID().toString();
        boolean isGetLock = cacheUtil.tryLock(key, value, repeatedSubmitAnno.expireTime());
        if (isGetLock) {
            // 测试释放锁接口是否可用
//            HtJmsModel model = new HtJmsModel();
//            model.setCode(JedisMsgKeyEnum.RELEASE_LOCK.getChanel());
//            model.setMsg(key);
//            model.setData(value);
//            ScheduledMessagePostProcessor postProcessor = new ScheduledMessagePostProcessor();
//            postProcessor.setDelay(10000L);
//            scheduledPublisher.sendQueue(model, postProcessor);
            // 立即释放锁
//            cacheUtil.releaseLock(key, value);
            return joinPoint.proceed();
        }
        return HtResultInfoWrapper.fail(HtCommonErrorEnum.NOT_REPEATED_SUBMIT);
    }
}