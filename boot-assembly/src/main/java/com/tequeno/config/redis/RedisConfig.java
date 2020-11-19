package com.tequeno.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    private final static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    /**
     * 注册一个bean映射类禁用空bean情况
     *
     * @return
     */
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        //设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
//        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//        // 丢弃空健
//        objectMapper.getSerializerProvider().setNullKeySerializer(new MyNullKeySerializer());
//        // 丢弃空值
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper());
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        try {
            // 如果没有异常则表示redis正常启动
            RedisConnection connection = factory.getConnection();
            logger.debug("redis正常启动:{}", connection);
            connection.close();
        } catch (Exception e) {
            logger.debug("redis未开启", e);
        }
        return template;
    }

    @Bean
    public RedisUtil jedisredisUtil() {
        return new RedisUtil();
    }

//    @Bean
//    public ChannelTopic channelTopic() {
//        return new ChannelTopic("string-topic");
//    }
//
//    @Bean
//    public PatternTopic patternTopic() {
//        return new PatternTopic("*");
//    }
//
//    @Bean
//    public MessageListener messageListener() {
//        return new JedisMessageListener();
//    }
//
//    @Bean
//    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory factory) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(factory);
//        container.addMessageListener(messageListener(), patternTopic());
//        return container;
//    }
}