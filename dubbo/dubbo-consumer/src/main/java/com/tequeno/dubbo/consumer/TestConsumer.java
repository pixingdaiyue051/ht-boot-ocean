package com.tequeno.dubbo.consumer;

import com.tequeno.dubbo.model.TestModel;
import com.tequeno.dubbo.service.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desription:
 * @Author: hexk
 */
@RestController
public class TestConsumer {

    @Reference
    private TestService service;

    @RequestMapping("test")
    public String test() {
        return service.test();
    }

    @RequestMapping("fake")
    public String fake() {
        TestModel model = service.getModel();
        TestModel testModel = service.getModel(model);
        System.out.println(testModel);
        return service.fake();
    }
}
