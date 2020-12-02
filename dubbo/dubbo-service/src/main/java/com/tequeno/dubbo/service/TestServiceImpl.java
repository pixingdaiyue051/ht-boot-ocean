package com.tequeno.dubbo.service;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @Desription:
 * @Author: hexk
 */
@Service
@Component
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "hello dubbo";
    }

    @Override
    public String fake() {
        return "fake";
    }
}
