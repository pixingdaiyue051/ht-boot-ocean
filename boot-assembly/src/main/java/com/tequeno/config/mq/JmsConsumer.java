package com.tequeno.config.mq;

import com.tequeno.common.constants.HtJmsConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSConsumer;
import javax.jms.Message;

@Component
public class JmsConsumer {

    private final static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);

    @JmsListener(destination = HtJmsConstant.TOPIC_NAME_1, containerFactory = HtJmsConstant.TOPIC_CONTAINER_FACTORY)
    public void onTopicMessage1(Message msg) {
        logger.info("接收到[{}]的topic消息:[{}]", HtJmsConstant.TOPIC_NAME_1, msg);
    }

    @JmsListener(destination = HtJmsConstant.QUEUE_NAME_1, containerFactory = HtJmsConstant.QUEUE_CONTAINER_FACTORY)
    public void onQueueMessage1(Message msg) {
        logger.info("接收到[{}]的queue消息:[{}]", HtJmsConstant.QUEUE_NAME_1, msg);
    }

    @JmsListener(destination = HtJmsConstant.TOPIC_NAME_2, containerFactory = HtJmsConstant.TOPIC_CONTAINER_FACTORY)
    public void onTopicMessage2(Message msg) {
        logger.info("接收到[{}]的topic消息:[{}]", HtJmsConstant.TOPIC_NAME_2, msg);
    }

    @JmsListener(destination = HtJmsConstant.QUEUE_NAME_2, containerFactory = HtJmsConstant.QUEUE_CONTAINER_FACTORY)
    public void onQueueMessage2(Message msg) {
        logger.info("接收到[{}]的queue消息:[{}]", HtJmsConstant.QUEUE_NAME_2, msg);
    }
}