//package com.tequeno.config.mq.rocketmq;
//
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 消息发送方,使用不同instance区别
// *
// * @author : hexk
// * @date : 2019-11-26 10:59
// **/
//@Configuration
//public class DefaultMqProducerConfig {
//
//    private final static Logger logger = LoggerFactory.getLogger(DefaultMqProducerConfig.class);
//
//    @Value("${rocketmq.producerGroup}")
//    private String producerGroup;
//
//    @Value("${rocketmq.namesrvAddr}")
//    private String namesrvAddr;
//
//    @Value("${rocketmq.producer.retryTimesWhenSendFailed}")
//    private String retryTimesWhenSendFailed;
//
//    @Value("${rocketmq.producer.retryTimesWhenSendAsyncFailed}")
//    private String retryTimesWhenSendAsyncFailed;
//
//    @Value("${rocketmq.producer.vipChannelEnabled}")
//    private String vipChannelEnabled;
//
//    @Value("${rocketmq.producer.instanceName}")
//    private String instanceName;
//
//    @Value("${rocketmq.producer.sendMsgTimeout}")
//    private String sendMsgTimeout;
//
//    @Value("${rocketmq.producer.maxMessageSize}")
//    private String maxMessageSize;
//
//    @Bean(destroyMethod = "shutdown")
//    public DefaultMQProducer defaultMQProducer() {
//        try {
//            DefaultMQProducer producer = new DefaultMQProducer(producerGroup);
//            producer.setNamesrvAddr(namesrvAddr);
//            producer.setRetryTimesWhenSendFailed(Integer.parseInt(retryTimesWhenSendFailed));
//            producer.setRetryTimesWhenSendAsyncFailed(Integer.parseInt(retryTimesWhenSendAsyncFailed));
//            producer.setVipChannelEnabled(Boolean.getBoolean(vipChannelEnabled));
//            producer.setInstanceName(instanceName);
//            producer.setSendMsgTimeout(Integer.parseInt(sendMsgTimeout));
//            producer.setMaxMessageSize(Integer.parseInt(maxMessageSize));
//            producer.start();
//            return producer;
//        } catch (MQClientException e) {
//            logger.debug("rocketmq producer[{}]启动失败", instanceName, e);
//            return null;
//        }
//    }
//}