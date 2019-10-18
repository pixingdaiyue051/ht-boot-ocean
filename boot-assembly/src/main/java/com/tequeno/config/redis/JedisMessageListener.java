package com.tequeno.config.redis;

import com.tequeno.common.enums.JedisMsgKeyEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public class JedisMessageListener implements MessageListener {

    private final static Logger logger = LoggerFactory.getLogger(JedisMessageListener.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @param message 消息体，包含了主题和内容
     * @param bytes   消息匹配模式，注册时设置的
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        RedisSerializer<?> topicSerializer = redisTemplate.getKeySerializer();
        RedisSerializer<?> msgSerializer = redisTemplate.getValueSerializer();
        Object channel = topicSerializer.deserialize(message.getChannel());
        if(JedisMsgKeyEnum.TEST.getChanel().equals(channel)){
            Object body = msgSerializer.deserialize(message.getBody());
            logger.info("接收到测试主题:[{}]", channel);
            logger.info("接收到测试消息内容:[{}]", body);
        }
    }
}