//package com.tequeno.config.mq;
//
//import com.tequeno.common.enums.HtCommonErrorEnum;
//import com.tequeno.common.enums.JedisMsgKeyEnum;
//import com.tequeno.common.mq.HtJmsConstant;
//import com.tequeno.common.mq.HtJmsModel;
//import com.tequeno.common.utils.HtCommonException;
//import com.tequeno.config.cache.RedisUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//import javax.jms.JMSConsumer;
//import javax.jms.Message;
//import javax.jms.ObjectMessage;
//
//@Component
//public class JmsConsumer {
//
//    private final static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);
//
//    @Autowired
//    private RedisUtil redisUtil;
//
//    @JmsListener(destination = HtJmsConstant.TOPIC_SCHEDULED_NAME, containerFactory = HtJmsConstant.TOPIC_CONTAINER_FACTORY)
//    public void onScheduledTopicMessage(Message msg) {
//        try {
//            ObjectMessage objectMessage = (ObjectMessage) msg;
//            HtJmsModel model = (HtJmsModel) objectMessage.getObject();
//            logger.info("接收到[{}]的topic消息:[{}]", HtJmsConstant.TOPIC_SCHEDULED_NAME, model);
//        } catch (Exception e) {
//            throw new HtCommonException(HtCommonErrorEnum.JMS_ERROR.build(e.getMessage()));
//        }
//    }
//
//    @JmsListener(destination = HtJmsConstant.QUEUE_SCHEDULED_NAME, containerFactory = HtJmsConstant.QUEUE_CONTAINER_FACTORY)
//    public void onScheduledQueueMessage(HtJmsModel model) {
//        try {
//            logger.info("接收到[{}]的queue消息:[{}]", HtJmsConstant.QUEUE_SCHEDULED_NAME, model);
//            if (JedisMsgKeyEnum.RELEASE_LOCK.getChanel().equals(model.getCode())) {
//                String key = model.getMsg();
//                String value = model.getData().toString();
//                redisUtil.releaseLock(key, value);
//            }
//        } catch (Exception e) {
//            throw new HtCommonException(HtCommonErrorEnum.JMS_ERROR.build(e.getMessage()));
//        }
//    }
//
//    @JmsListener(destination = HtJmsConstant.TOPIC_SIMPLE_NAME, containerFactory = HtJmsConstant.TOPIC_CONTAINER_FACTORY)
//    public void onSimpleTopicMessage(Message msg) {
//        try {
//            ObjectMessage objectMessage = (ObjectMessage) msg;
//            HtJmsModel model = (HtJmsModel) objectMessage.getObject();
//            logger.info("接收到[{}]的topic消息:[{}]", HtJmsConstant.TOPIC_SIMPLE_NAME, model);
//        } catch (Exception e) {
//            throw new HtCommonException(HtCommonErrorEnum.JMS_ERROR.build(e.getMessage()));
//        }
//    }
//
//    @JmsListener(destination = HtJmsConstant.QUEUE_SIMPLE_NAME, containerFactory = HtJmsConstant.QUEUE_CONTAINER_FACTORY)
//    public void onSimpleQueueMessage(HtJmsModel model) {
//        try {
//            logger.info("接收到[{}]的queue消息:[{}]", HtJmsConstant.QUEUE_SIMPLE_NAME, model);
//        } catch (Exception e) {
//            throw new HtCommonException(HtCommonErrorEnum.JMS_ERROR.build(e.getMessage()));
//        }
//    }
//}