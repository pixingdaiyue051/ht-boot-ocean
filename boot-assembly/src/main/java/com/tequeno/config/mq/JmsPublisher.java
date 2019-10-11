package com.tequeno.config.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class JmsPublisher {

    @Autowired
    private JmsMessagingTemplate jms;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    public void sendQueue(Object o) {
        jms.convertAndSend(queue, o);
    }

    public void sendTopic(Object o) {
        jms.convertAndSend(topic, o);
    }
}