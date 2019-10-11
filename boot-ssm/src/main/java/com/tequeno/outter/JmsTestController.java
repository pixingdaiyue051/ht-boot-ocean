//package com.tequeno.outter;
//
//import com.tequeno.common.constants.ResultBinder;
//import com.tequeno.common.utils.HtResultInfoWrapper;
//import com.tequeno.config.mq.JmsPublisher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("test/jms")
//public class JmsTestController {
//
//    @Autowired
//    private JmsPublisher publisher;
//
//    @PostMapping("queue")
//    public ResultBinder queue(@RequestParam("param") String param) {
//        publisher.sendQueue(param);
//        return HtResultInfoWrapper.success();
//    }
//
//    @PostMapping("topic")
//    public ResultBinder topic(@RequestParam("param") String param) {
//        publisher.sendTopic(param);
//        return HtResultInfoWrapper.success();
//    }
//}
