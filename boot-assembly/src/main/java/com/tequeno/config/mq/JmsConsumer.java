//package com.tequeno.config.mq;
//
//import com.tequeno.common.constants.HtJmsConstant;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//import javax.jms.JMSConsumer;
//
//@Component
//public class JmsConsumer {
//
//    private final static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);
//
//    @JmsListener(destination = HtJmsConstant.TOPIC_NAME, containerFactory = HtJmsConstant.TOPIC_CONTAINER_FACTORY)
//    public void onTopicMessage(String msg) {
//        logger.info("接收到topic消息:[{}]", msg);
//    }
//
//    @JmsListener(destination = HtJmsConstant.QUEUE_NAME, containerFactory = HtJmsConstant.QUEUE_CONTAINER_FACTORY)
//    public void onQueueMessage(String msg) {
//        logger.info("接收到queue消息:[{}]", msg);
//    }
//}