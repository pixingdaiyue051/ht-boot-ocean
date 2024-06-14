package com.tequeno.constants;

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
    public final static String QUEUE_SCHEDULED_NAME = "scheduledQueue";
    public final static String QUEUE_SIMPLE_NAME = "simpleQueue";

    /**
     * 主题名字
     */
    public final static String TOPIC_SCHEDULED_NAME = "scheduledTopic";
    public final static String TOPIC_SIMPLE_NAME = "simpleTopic";

    public final static String ROCKET_TAG_A = "r_tag_a";
    public final static String ROCKET_TAG_B = "r_tag_b";
    public final static String PRODUCER_INSTANCE_NAME_A = "producerInstanceA";
    public final static String PRODUCER_INSTANCE_NAME_B = "producerInstanceB";
    public final static String CONSUMER_INSTANCE_NAME_A = "consumerInstanceA";
    public final static String CONSUMER_INSTANCE_NAME_B = "consumerInstanceB";
}