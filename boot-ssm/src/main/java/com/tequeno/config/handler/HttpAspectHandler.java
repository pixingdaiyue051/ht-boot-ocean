package com.tequeno.bootssm.config.handler;

import com.tequeno.common.utils.ResultBinderUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    @Pointcut("execution(* com.tequeno.bootssm.controller.*.*(..))")
    public void controllerAspect() {
    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Signature s = joinPoint.getSignature();
        logger.info("{}方法,开始执行...", s.getDeclaringType().getSimpleName() + "." + s.getName());
        logger.info("url={}", request.getRequestURI());
        logger.info("method={}", request.getMethod());
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        Signature s = joinPoint.getSignature();
        logger.info("{}方法,执行结束", s.getDeclaringType().getSimpleName() + "." + s.getName());
    }

//    @Around("controllerAspect()")
//    public void doAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        logger.info("HttpAspectHandler.doAround");
//
//        Object obj = joinPoint.proceed();
//        System.out.println(obj);
//
//    }

    @AfterReturning(returning = "obj", pointcut = "controllerAspect()")
    public void doAfterReturning(Object obj) {
        logger.info("response={}", obj.toString());
    }
}
