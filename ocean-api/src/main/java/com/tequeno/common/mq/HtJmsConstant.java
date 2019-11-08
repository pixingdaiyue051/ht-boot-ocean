package com.tequeno.common.mq;

public class HtJmsConstant {

    /**
     * jms主题订阅模式容器bean名字
     */
    public final static String TOPIC_CONTAINER_FACTORY = "jmsListenerContainerTopic";

    /**
     * jms队列模式容器bean名字
     */
    public final static String QUEUE_CONTAINER_FACTORY = "jmsListenerContainerQueue";

    /**
     * 队列名字
     */
    public final static String QUEUE_SCHEDULED_NAME = "queue.scheduled";
    public final static String QUEUE_SIMPLE_NAME = "queue.simple";

    /**
     * 主题名字
     */
    public final static String TOPIC_SCHEDULED_NAME = "topic.scheduled";
    public final static String TOPIC_SIMPLE_NAME = "topic.simple";
}