package com.tequeno.bootassembly.enc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Encryption {

    Type value() default Type.HANDSHAKE;

    enum Type {
        ENCRYPT,
        DECRYPT,
        HANDSHAKE;

        Type() {
        }
    }
}
