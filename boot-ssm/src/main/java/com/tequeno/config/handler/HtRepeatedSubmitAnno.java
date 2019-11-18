package com.tequeno.config.handler;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HtRepeatedSubmitAnno {

    long expireTime() default 1000L;
}