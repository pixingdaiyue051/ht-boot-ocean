package com.tequeno.dubbo.service;

/**
 * @Desription:
 * @Author: hexk
 */
public interface IndexService {

    default String index() {
        return "hello index";
    }
}
