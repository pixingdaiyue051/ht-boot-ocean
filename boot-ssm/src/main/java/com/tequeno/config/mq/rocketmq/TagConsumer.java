package com.tequeno.config.mq.rocketmq;

import com.alibaba.fastjson.JSON;
import com.tequeno.common.mq.HtJmsConstant;
import com.tequeno.common.mq.HtJmsModel;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 消息接收体，编写业务代码
 *
 * @author : hexk
 * @date : 2019-11-26 11:21
 **/
@Configuration
public class TagConsumer extends DefaultMqConsumerConfig implements ApplicationListener<ContextRefreshedEvent> {

    private final static Logger logger = LoggerFactory.getLogger(TagConsumer.class);

    @Bean(HtJmsConstant.CONSUMER_INSTANCE_NAME_A)
    public DefaultMQPushConsumer pushConsumer() {
        try {
            return super.defaultMQConsumer(HtJmsConstant.CONSUMER_INSTANCE_NAME_A);
        } catch (MQClientException e) {
            logger.debug("rocketmq consumer启动失败", e);
            return null;
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        pushConsumer();
    }

    @Override
    public ConsumeConcurrentlyStatus onMsgConsume(List<MessageExt> msgList) {
        MessageExt messageExt = msgList.get(0);
        String body = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        HtJmsModel model = JSON.parseObject(body, HtJmsModel.class);
        long bornTimestamp = messageExt.getBornTimestamp();
        long storeTimestamp = messageExt.getStoreTimestamp();
        String topic = messageExt.getTopic();
        String tags = messageExt.getTags();
        logger.debug("[{}]接收到[{}]", Thread.currentThread().getName(), messageExt);
        logger.debug("topic:[{}],tag:[{}],body:[{}],delay:[{}]", topic, tags, model, storeTimestamp - bornTimestamp);
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}