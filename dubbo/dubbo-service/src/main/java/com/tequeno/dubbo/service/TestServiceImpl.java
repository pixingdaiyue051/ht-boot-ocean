package com.tequeno.dubbo.service;


import com.tequeno.dubbo.model.TestModel;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

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

    @Override
    public TestModel getModel(TestModel testModel) {
        testModel.setList(Arrays.asList("1", "2", "3"));
        return testModel;
    }

    @Override
    public TestModel getModel() {
        TestModel testModel = new TestModel();
        byte b = 0;
        testModel.setaByte(b);
        short s = 0;
        testModel.setaShort(s);
        testModel.setaInt(0);
        testModel.setaLong(0L);
        testModel.setaFloat(0F);
        testModel.setaDouble(0D);
        testModel.setaChar('c');
        testModel.setaBoolean(false);
        testModel.setStr("s");
        testModel.setList(Collections.EMPTY_LIST);
        testModel.setMap(Collections.EMPTY_MAP);
        return testModel;
    }
}
