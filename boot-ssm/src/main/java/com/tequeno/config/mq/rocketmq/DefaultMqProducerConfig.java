package com.tequeno.config.mq.rocketmq;

import com.tequeno.common.mq.HtJmsConstant;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息发送方,使用不同instance区别
 *
 * @author : hexk
 * @date : 2019-11-26 10:59
 **/
@Configuration
public class DefaultMqProducerConfig {

    private final static Logger logger = LoggerFactory.getLogger(DefaultMqProducerConfig.class);

    @Value("${rocketmq.groupName}")
    private String groupName;

    @Value("${rocketmq.namesrvAddr}")
    private String namesrvAddr;

    @Value("${rocketmq.failedRetry}")
    private String failedRetry;

    @Value("${rocketmq.vipEnabled}")
    private String vipEnabled;

    @Bean(HtJmsConstant.PRODUCER_INSTANCE_NAME_A)
    public DefaultMQProducer producerWithInstanceA() {
        try {
            DefaultMQProducer producer = generateProducer(HtJmsConstant.PRODUCER_INSTANCE_NAME_A);
            return producer;
        } catch (MQClientException e) {
            logger.debug("rocketmq producer[{}]启动失败", HtJmsConstant.PRODUCER_INSTANCE_NAME_A, e);
            return null;
        }
    }

    @Bean(HtJmsConstant.PRODUCER_INSTANCE_NAME_B)
    public DefaultMQProducer producerWithInstanceB() {
        try {
            DefaultMQProducer producer = generateProducer(HtJmsConstant.PRODUCER_INSTANCE_NAME_B);
            return producer;
        } catch (MQClientException e) {
            logger.debug("rocketmq producer[{}]启动失败", HtJmsConstant.PRODUCER_INSTANCE_NAME_B, e);
            return null;
        }
    }

    private DefaultMQProducer generateProducer(String instanceBName) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer(groupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setRetryTimesWhenSendFailed(Integer.parseInt(failedRetry));
        producer.setVipChannelEnabled(Boolean.getBoolean(vipEnabled));
        producer.setInstanceName(instanceBName);
        producer.start();
        return producer;
    }
}