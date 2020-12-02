package com.tequeno.dubbo.service;

/**
 * @Desription:
 * @Author: hexk
 */
public interface TestService {

    default String test() {
        return "hello world";
    }

    String fake();
}
