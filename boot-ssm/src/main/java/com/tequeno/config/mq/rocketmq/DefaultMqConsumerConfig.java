package com.tequeno.config.mq.rocketmq;

import com.tequeno.common.mq.HtJmsConstant;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * 消息接收方,具体业务由子类实现
 *
 * @author : hexk
 * @date : 2019-11-26 10:59
 **/
public abstract class DefaultMqConsumerConfig {

    @Value("${rocketmq.groupName}")
    private String groupName;

    @Value("${rocketmq.topic}")
    private String topic;

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;

    public DefaultMQPushConsumer defaultMQConsumer(String instanceName) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.subscribe(topic, HtJmsConstant.DEFAULT_SUBSCRIBED_TAGS);
        consumer.setInstanceName(instanceName);
        consumer.registerMessageListener((MessageListenerConcurrently) (msgList, context) -> onMsgConsume(msgList));
        consumer.start();
        return consumer;
    }

    public abstract ConsumeConcurrentlyStatus onMsgConsume(List<MessageExt> msgList);
}