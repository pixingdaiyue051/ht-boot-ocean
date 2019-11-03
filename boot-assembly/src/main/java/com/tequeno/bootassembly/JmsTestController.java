package com.tequeno.bootassembly;

import com.tequeno.common.constants.ResultBinder;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.mq.JmsPublisher;
import com.tequeno.config.mq.JmsScheduledPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/jms")
public class JmsTestController {

    @Autowired
    private JmsPublisher publisher;

    @Autowired
    private JmsScheduledPublisher scheduledPublisher;

    @RequestMapping("queue")
    public ResultBinder queue(@RequestParam("param") String param) {
        publisher.sendQueue(param);
        scheduledPublisher.sendQueue(param);
        return HtResultInfoWrapper.success();
    }

    @RequestMapping("topic")
    public ResultBinder topic(@RequestParam("param") String param) {
        publisher.sendTopic(param);
        scheduledPublisher.sendTopic(param);
        return HtResultInfoWrapper.success();
    }
}