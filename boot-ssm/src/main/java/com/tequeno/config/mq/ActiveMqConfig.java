package com.tequeno.config.mq;

import com.tequeno.common.mq.HtJmsConstant;
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
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ActiveMqConfig {

    @Value("${spring.activemq.user}")
    private String user;

    @Value("${spring.activemq.password}")
    private String password;

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Bean(HtJmsConstant.QUEUE_SCHEDULED_NAME)
    public Queue queueScheduled() {
        return new ActiveMQQueue(HtJmsConstant.QUEUE_SCHEDULED_NAME);
    }

    @Bean(HtJmsConstant.TOPIC_SCHEDULED_NAME)
    public Topic topicScheduled() {
        return new ActiveMQTopic(HtJmsConstant.TOPIC_SCHEDULED_NAME);
    }

    @Bean(HtJmsConstant.QUEUE_SIMPLE_NAME)
    public Queue queueSimple() {
        return new ActiveMQQueue(HtJmsConstant.QUEUE_SIMPLE_NAME);
    }

    @Bean(HtJmsConstant.TOPIC_SIMPLE_NAME)
    public Topic topicSimple() {
        return new ActiveMQTopic(HtJmsConstant.TOPIC_SIMPLE_NAME);
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(user, password, brokerUrl);
        List<String> packageList = new ArrayList<>();
        packageList.add("java.util");
        packageList.add("java.lang");
        packageList.add("com.tequeno.common.mq");
        factory.setTrustedPackages(packageList);
        return factory;
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