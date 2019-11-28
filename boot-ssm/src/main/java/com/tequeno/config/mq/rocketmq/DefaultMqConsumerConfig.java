package com.tequeno.config.mq.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 消息接收方,具体业务由子类实现
 *
 * @author : hexk
 * @date : 2019-11-26 10:59
 **/
@Configuration
public abstract class DefaultMqConsumerConfig {

    private final static Logger logger = LoggerFactory.getLogger(DefaultMqConsumerConfig.class);

    @Value("${rocketmq.producerGroup}")
    private String producerGroup;

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @Value("${rocketmq.consumer.instanceName}")
    private String instanceName;

    @Value("${rocketmq.consumer.topic}")
    private String topic;

    @Value("${rocketmq.consumer.subExpression}")
    private String subExpression;

    @Value("${rocketmq.consumer.consumeTimeout}")
    private String consumeTimeout;

    @Value("${rocketmq.consumer.consumeThreadMin}")
    private String consumeThreadMin;

    @Value("${rocketmq.consumer.consumeThreadMax}")
    private String consumeThreadMax;

    @Value("${rocketmq.consumer.consumeMessageBatchMaxSize}")
    private String consumeMessageBatchMaxSize;

    @Bean(destroyMethod = "shutdown")
    public DefaultMQPushConsumer defaultMQPushConsumer() {
        try {
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(producerGroup);
            consumer.setNamesrvAddr(namesrvAddr);
            consumer.setInstanceName(instanceName);
            consumer.subscribe(topic, subExpression);
            consumer.setConsumeThreadMin(Integer.parseInt(consumeThreadMin));
            consumer.setConsumeThreadMax(Integer.parseInt(consumeThreadMax));
            consumer.setConsumeTimeout(Long.parseLong(consumeTimeout));
            consumer.setConsumeMessageBatchMaxSize(Integer.parseInt(consumeMessageBatchMaxSize));
            consumer.registerMessageListener((MessageListenerConcurrently) (msgList, consumeConcurrentlyContext) -> this.onMsgConsume(msgList));
            consumer.start();
            return consumer;
        } catch (MQClientException e) {
            logger.debug("rocketmq consumer[{}]启动失败", instanceName, e);
            return null;
        }
    }

    public abstract ConsumeConcurrentlyStatus onMsgConsume(List<MessageExt> msgList);

}