package com.tequeno.config.mq.rocketmq;//package com.tequeno.config.mq.rocketmq;
//
//import com.alibaba.fastjson.JSON;
//import com.tequeno.common.mq.HtJmsModel;
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.apache.rocketmq.client.producer.SendCallback;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.remoting.common.RemotingHelper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * 封装消息发送
// *
// * @author : hexk
// * @date : 2019-11-26 11:39
// **/
//@Component
//public class MsgSendProducer {
//
//    private final static Logger logger = LoggerFactory.getLogger(MsgSendProducer.class);
//
//    @Value("${rocketmq.consumer.topic}")
//    private String topic;
//
//    @Autowired
//    private DefaultMQProducer producer;
//
//    /**
//     * 同步发送一条消息
//     *
//     * @param tag
//     * @param model
//     * @return
//     */
//    public SendResult send(String tag, HtJmsModel model) {
//        return send(tag, model, null);
//    }
//
//    /**
//     * 同步发送消息
//     * default level
//     * 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
//     *
//     * @param tag
//     * @param model
//     * @param key
//     * @return
//     */
//    public SendResult send(String tag, HtJmsModel model, String... key) {
//        try {
//            byte[] body = JSON.toJSONString(model).getBytes(RemotingHelper.DEFAULT_CHARSET);
//            Message msg = new Message(topic, body);
//            msg.setTags(tag);
//            if (null != key) {
//                msg.setKeys(Arrays.asList(key));
//            }
//            if (null != model.getTimeLevel()) {
//                msg.setDelayTimeLevel(model.getTimeLevel());
//            }
//            return producer.send(msg);
//        } catch (Exception e) {
//            logger.debug("同步发送消息[{}]失败", model, e);
//            return null;
//        }
//    }
//
//
//    /**
//     * 同步发送多条消息
//     *
//     * @param tag
//     * @param modelList
//     * @return
//     */
//    public SendResult send(String tag, List<HtJmsModel> modelList) {
//        try {
//            List<Message> msgList = modelList.stream().map(model -> {
//                byte[] body;
//                try {
//                    body = JSON.toJSONString(model).getBytes(RemotingHelper.DEFAULT_CHARSET);
//                } catch (UnsupportedEncodingException e) {
//                    logger.debug("消息体[{}]转json序列化失败", model, e);
//                    return null;
//                }
//                Message msg = new Message(topic, body);
//                msg.setTags(tag);
//                return msg;
//            }).collect(Collectors.toList());
//            return producer.send(msgList);
//        } catch (Exception e) {
//            logger.debug("同步发送多条消息发送失败", e);
//            return null;
//        }
//    }
//
//    /**
//     * 异步发送消息
//     *
//     * @param tag
//     * @param model
//     * @param sendCallback
//     */
//    public void asyncSend(String tag, HtJmsModel model, SendCallback sendCallback) {
//        try {
//            byte[] body = JSON.toJSONString(model).getBytes(RemotingHelper.DEFAULT_CHARSET);
//            Message msg = new Message(topic, body);
//            msg.setTags(tag);
//            if (null != model.getTimeLevel()) {
//                msg.setDelayTimeLevel(model.getTimeLevel());
//            }
//            producer.send(msg, sendCallback);
//        } catch (Exception e) {
//            logger.debug("异步发送消息[{}]失败", model, e);
//        }
//    }
//}