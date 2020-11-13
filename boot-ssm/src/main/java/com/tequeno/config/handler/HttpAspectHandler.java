//package com.tequeno.config.handler;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Component
//@Aspect
//public class HttpAspectHandler {
//
//    private final static Logger logger = LoggerFactory.getLogger(HttpAspectHandler.class);
//
//    @Pointcut("execution(* com.tequeno.bootssm.controller..*.*(..))")
//    public void controllerAspect() {
//    }
//
//    @Before("controllerAspect()")
//    public void doAdviceBeforeHttp(JoinPoint joinPoint) {
//        logger.debug("doAdviceBeforeHttp");
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        Signature s = joinPoint.getSignature();
//        logger.debug("[{}.{}]方法,开始执行...", s.getDeclaringTypeName(), s.getName());
//        logger.debug("url:[{}]", request.getRequestURI());
//        logger.debug("method:[{}]", request.getMethod());
//        logger.debug("args:[{}]", joinPoint.getArgs());
//    }
//
//    @After("controllerAspect()")
//    public void doAdviceAfterHttp(JoinPoint joinPoint) {
//        logger.debug("doAdviceAfterHttp");
//        Signature s = joinPoint.getSignature();
//        logger.debug("[{}.{}]方法,开始执行...", s.getDeclaringTypeName(), s.getName());
//    }
//
////    @AfterReturning(returning = "obj", pointcut = "controllerAspect()")
////    public void doAfterReturningHttp(Object obj) {
////        logger.debug("doAfterReturningHttp");
////        logger.debug("response:[{}]", obj);
////    }
//
////    @AfterThrowing(throwing = "error", pointcut = "controllerAspect()")
////    public void doAfterThrowingHttp(Object obj) {
////        logger.debug("response:[{}]", obj);
////    }
//}