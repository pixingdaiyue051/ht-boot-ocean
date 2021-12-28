package com.tequeno.bootassembly.ws.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {

    private MyClientHandler handler;

    public MyClientInitializer(MyClientHandler handler) {
        this.handler = handler;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        //以下三个是Http的支持
        //http解码器
        pipeline.addLast(new HttpClientCodec());
//        //支持写大数据流
//        pipeline.addLast(new ChunkedWriteHandler());
        //http聚合器
        pipeline.addLast(new HttpObjectAggregator(65536));
        // 将消息转换成TextWebSocketFrame发送
        pipeline.addLast(new MyClientEncoder());
        // 心跳包
        pipeline.addLast(new IdleStateHandler(0, 30, 0, TimeUnit.SECONDS));
        // 自定义消息接收器
        pipeline.addLast(handler);
    }
}