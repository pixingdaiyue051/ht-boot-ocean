package com.tequeno.bootassembly;

import com.tequeno.common.constants.HtResultBinder;
import com.tequeno.common.mq.HtJmsConstant;
import com.tequeno.common.mq.HtJmsModel;
import com.tequeno.common.utils.HtResultInfoWrapper;
import com.tequeno.config.mq.rocketmq.MsgSendProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 消息发送rest接口
 *
 * @author : hexk
 * @date : 2019-11-26 14:22
 **/
@RestController
@RequestMapping("test/rocket")
public class RocketMqTestController {

    private final static Logger logger = LoggerFactory.getLogger(RocketMqTestController.class);

    @Autowired
    private MsgSendProducer producer;

    @RequestMapping("sync")
    public HtResultBinder sendSync(@RequestParam("msg") String msg,
                                   @RequestParam(value = "timeLevel", required = false) Integer timeLevel) {
        HtJmsModel model = new HtJmsModel();
        model.setMsg(msg);
        model.setTimeLevel(timeLevel);
        SendResult result = producer.send(HtJmsConstant.ROCKET_TAG_A, model);
        return HtResultInfoWrapper.success(result);
    }

    @RequestMapping("async")
    public HtResultBinder sendAsync(@RequestParam("msg") String msg,
                                    @RequestParam(value = "timeLevel", required = false) Integer timeLevel) {
        HtJmsModel model = new HtJmsModel();
        model.setMsg(msg);
        model.setTimeLevel(timeLevel);
        producer.asyncSend(HtJmsConstant.ROCKET_TAG_B, model,
                new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        logger.debug("异步发送成功[{}]", sendResult);
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        logger.debug("异步发送失败", throwable);
                    }
                });
        return HtResultInfoWrapper.success();
    }

    @RequestMapping("batch")
    public HtResultBinder batchSend() {
        List<HtJmsModel> list = IntStream.rangeClosed(1, 10)
                .boxed()
                .map(i -> {
                    HtJmsModel model = new HtJmsModel();
                    model.setMsg(String.valueOf(i));
                    model.setTimeLevel(i);
                    return model;
                })
                .collect(Collectors.toList());
        producer.send(HtJmsConstant.ROCKET_TAG_B, list);
        return HtResultInfoWrapper.success();
    }
}