package com.tequeno.config.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class HttpAspectHandler {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspectHandler.class);

    @Pointcut("execution(* com.tequeno.bootssm.controller..*.*(..))")
    public void controllerAspect() {
    }

    @Before("controllerAspect()")
    public void doAdviceBeforeHttp(JoinPoint joinPoint) {
        logger.info("doAdviceBeforeHttp");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Signature s = joinPoint.getSignature();
        logger.info("{}.{}方法,开始执行...", s.getDeclaringType().getSimpleName(), s.getName());
        logger.info("url={}", request.getRequestURI());
        logger.info("method={}", request.getMethod());
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("controllerAspect()")
    public void doAdviceAfterHttp(JoinPoint joinPoint) {
        logger.info("doAdviceAfterHttp");
        Signature s = joinPoint.getSignature();
        logger.info("{}.{}方法,开始执行...", s.getDeclaringType().getSimpleName(), s.getName());
    }

//    @AfterReturning(returning = "obj", pointcut = "controllerAspect()")
//    public void doAfterReturningHttp(Object obj) {
//        logger.info("doAfterReturningHttp");
//        logger.info("response={}", obj);
//    }

//    @AfterThrowing(throwing = "error", pointcut = "controllerAspect()")
//    public void doAfterThrowingHttp(Object obj) {
//        logger.info("response={}", obj);
//    }
}