package com.tequeno.config.handler;

import com.tequeno.enums.HtUserResEnum;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HtPermissionAnno {

    HtUserResEnum[] value();

    Logical logical() default Logical.OR;

    enum Logical {
        AND,
        OR;

        Logical() {
        }
    }
}

