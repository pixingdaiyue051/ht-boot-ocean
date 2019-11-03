package com.tequeno.config.mq;

import com.tequeno.common.constants.HtJmsConstant;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMqConfig {

    @Value("${spring.activemq.user}")
    private String user;

    @Value("${spring.activemq.password}")
    private String password;

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Bean(HtJmsConstant.QUEUE_NAME_1)
    public Queue queue1() {
        return new ActiveMQQueue(HtJmsConstant.QUEUE_NAME_1);
    }

    @Bean(HtJmsConstant.TOPIC_NAME_1)
    public Topic topic1() {
        return new ActiveMQTopic(HtJmsConstant.TOPIC_NAME_1);
    }

    @Bean(HtJmsConstant.QUEUE_NAME_2)
    public Queue queue2() {
        return new ActiveMQQueue(HtJmsConstant.QUEUE_NAME_2);
    }

    @Bean(HtJmsConstant.TOPIC_NAME_2)
    public Topic topic2() {
        return new ActiveMQTopic(HtJmsConstant.TOPIC_NAME_2);
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(user, password, brokerUrl);
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        //设置为发布订阅方式, 默认情况下使用的生产消费者方式
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }
}