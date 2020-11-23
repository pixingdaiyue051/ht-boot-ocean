package com.tequeno.config.handler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HtRepeatedSubmitAnno {

    /**
     * 重复提交时间，即在该时段内只能提交一次
     *
     * @return
     */
    long expireTime() default 3000L;
}