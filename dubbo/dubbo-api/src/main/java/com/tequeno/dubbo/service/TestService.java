package com.tequeno.dubbo.service;

import com.tequeno.dubbo.model.TestModel;

/**
 * @Desription:
 * @Author: hexk
 */
public interface TestService {

    default String test() {
        return "hello world";
    }

    String fake();

    TestModel getModel(TestModel testModel);

    TestModel getModel();

}
