package com.tequeno.dubbo.consumer;

import com.tequeno.dubbo.model.TestModel;
import com.tequeno.dubbo.service.IndexService;
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
    private TestService testService;

    @Reference
    private IndexService indexService;

    @RequestMapping("test")
    public String test() {
        return testService.test();
    }

    @RequestMapping("fake")
    public String fake() {
        TestModel model = testService.getModel();
        TestModel testModel = testService.getModel(model);
        System.out.println(testModel);
        String index = indexService.index();
        System.out.println(index);
        return testService.fake();
    }
}
