package com.tequeno.config.cache;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tequeno.bootssm.mapper.sys.DataDictionaryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    private final static Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Autowired
    private DataDictionaryMapper dictionaryMapper;

    /**
     * 注册一个bean映射类禁用空bean情况
     *
     * @return
     */
//    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
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
            // 如果没有异常则表示redis
            RedisConnection connection = factory.getConnection();
            logger.info("redis正常启动,对应connection:{}", connection);
            initLoadDict2Cache(template);
        } catch (Exception e) {
            logger.info("redis未开启");
        }
        return template;
    }

    /**
     * 初始化将数据字典加入redis
     *
     * @param template
     */
    private void initLoadDict2Cache(RedisTemplate<String, Object> template) {
//        List<DataDictionary> dictionaryList = dictionaryMapper.selectAll();
//        dictionaryList.
//                stream().
//                collect(Collectors.groupingBy(DataDictionary::getTypeCode)).
//                forEach((k, v) -> {
//                    final String hashKey = JedisKeyPrefixEnum.HDICT.assemblyKey(k);
//                    v.forEach(d -> {
//                        template.opsForHash().put(hashKey, d.getValueCode(), d);
//                    });
//                });
    }

    @Bean
    public JedisCacheUtil jedisCacheUtil() {
        return new JedisCacheUtil();
    }

    @Bean
    public ChannelTopic channelTopic() {
        return new ChannelTopic("string-topic");
    }

    @Bean
    public PatternTopic patternTopic() {
        return new PatternTopic("*");
    }

    @Bean
    public MessageListener messageListener() {
        return new JedisMessageListener();
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory factory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(messageListener(), patternTopic());
        return container;
    }
}