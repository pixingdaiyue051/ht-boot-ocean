package com.tequeno.anno;

import com.tequeno.enums.HtUserResEnum;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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

