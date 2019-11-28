package com.tequeno.config.mq.rocketmq;

import com.alibaba.fastjson.JSON;
import com.tequeno.common.mq.HtJmsModel;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 消息接收体，编写业务代码
 *
 * @author : hexk
 * @date : 2019-11-26 11:21
 **/
@Component
public class MsgConsumer extends DefaultMqConsumerConfig {

    private final static Logger logger = LoggerFactory.getLogger(MsgConsumer.class);

    @Override
    public ConsumeConcurrentlyStatus onMsgConsume(List<MessageExt> msgList) {
        MessageExt messageExt = msgList.get(0);
        String body = new String(messageExt.getBody(), StandardCharsets.UTF_8);
        HtJmsModel model = JSON.parseObject(body, HtJmsModel.class);
        long bornTimestamp = messageExt.getBornTimestamp();
        long storeTimestamp = messageExt.getStoreTimestamp();
        String topic = messageExt.getTopic();
        String tags = messageExt.getTags();
        int reconsumeTimes = messageExt.getReconsumeTimes();
        logger.debug("[{}]接收到[{}]", Thread.currentThread().getName(), messageExt);
        logger.debug("topic:[{}],tag:[{}],body:[{}],reconsumeTimes:[{}],delay:[{}]", topic, tags, model, reconsumeTimes, storeTimestamp - bornTimestamp);
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}