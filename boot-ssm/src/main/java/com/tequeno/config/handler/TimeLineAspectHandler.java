package com.tequeno.config.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class TimeLineAspectHandler {

    private final static Logger logger = LoggerFactory.getLogger(TimeLineAspectHandler.class);

    private long beginSecond;

    private long endSecond;

    @Pointcut("execution(public * com.tequeno.bootssm.controller..*.*(..))")
    public void controllerAspect() {
    }

    @Before("controllerAspect()")
    public void doAdviceBeforeTimeLine() {
        logger.debug("doAdviceBeforeTimeLine");
        this.beginSecond = System.currentTimeMillis();
    }

    @After("controllerAspect()")
    public void doAdviceAfterTimeLine(JoinPoint joinPoint) {
        logger.debug("doAdviceAfterTimeLine");
        this.endSecond = System.currentTimeMillis();
        Signature s = joinPoint.getSignature();
        logger.debug("{}.{}方法,执行时间为{}ms", s.getDeclaringTypeName(), s.getName(), endSecond - beginSecond);
    }
}