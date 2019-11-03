package com.tequeno.config.mq;

import com.tequeno.common.constants.HtJmsConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class JmsScheduledPublisher {

    @Autowired
    private JmsMessagingTemplate jms;

    @Autowired
    @Qualifier(HtJmsConstant.QUEUE_NAME_2)
    private Queue queue2;

    @Autowired
    @Qualifier(HtJmsConstant.TOPIC_NAME_2)
    private Topic topic2;

    public void sendQueue(Object o) {
        jms.convertAndSend(queue2, o);
    }

    public void sendTopic(Object o) {
        jms.convertAndSend(topic2, o);
    }
}