package com.tequeno.dubbo.service;


import org.apache.dubbo.config.annotation.Service;

/**
 * @Desription:
 * @Author: hexk
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Override
    public String index() {
        System.out.println("------>index");
        return "hello world";
    }
}
