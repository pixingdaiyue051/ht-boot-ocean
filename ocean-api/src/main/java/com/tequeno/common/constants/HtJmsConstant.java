package com.tequeno.common.constants;

public class HtJmsConstant {

    /**
     * jms主题订阅模式容器bean名字
     */
    public static final String TOPIC_CONTAINER_FACTORY = "jmsListenerContainerTopic";

    /**
     * jms队列模式容器bean名字
     */
    public static final String QUEUE_CONTAINER_FACTORY = "jmsListenerContainerQueue";

    /**
     * 队列名字
     */
    public final static String QUEUE_NAME = "ht.publish.queue";

    /**
     * 主题名字
     */
    public final static String TOPIC_NAME = "ht.publish.topic";
}