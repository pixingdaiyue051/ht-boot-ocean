package com.tequeno.config.handler;

import com.tequeno.common.enums.JedisLockTimeEnum;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HtRedisLockAnno {

    /**
     * 为方法加锁
     *
     * @return
     */
    JedisLockTimeEnum value() default JedisLockTimeEnum.QUICK;
}