package com.tequeno.config.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

public class JedisMessageListener implements MessageListener {

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
        Object body = msgSerializer.deserialize(message.getBody());
        System.out.println("主题: " + channel);
        System.out.println("消息内容: " + body);
    }
}