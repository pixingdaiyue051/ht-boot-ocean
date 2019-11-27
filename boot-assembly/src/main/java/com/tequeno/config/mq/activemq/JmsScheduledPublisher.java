package com.tequeno.config.mq.activemq;

import com.tequeno.common.mq.HtJmsConstant;
import com.tequeno.common.mq.HtJmsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class JmsScheduledPublisher {

    @Autowired
    private JmsTemplate jms;

    @Autowired
    @Qualifier(HtJmsConstant.QUEUE_SCHEDULED_NAME)
    private Queue queue;

    @Autowired
    @Qualifier(HtJmsConstant.TOPIC_SCHEDULED_NAME)
    private Topic topic;

    public void sendQueue(HtJmsModel model, MessagePostProcessor postProcessor) {
        send(queue, model, postProcessor);
    }

    public void sendTopic(HtJmsModel model, MessagePostProcessor postProcessor) {
        send(topic, model, postProcessor);
    }

    public void send(Destination destination, HtJmsModel model, MessagePostProcessor postProcessor) {
        jms.convertAndSend(destination, model, postProcessor);
    }
}