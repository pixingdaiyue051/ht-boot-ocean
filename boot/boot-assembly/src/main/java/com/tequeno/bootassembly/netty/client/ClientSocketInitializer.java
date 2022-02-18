package com.tequeno.bootassembly.netty.client;

import com.tequeno.bootassembly.netty.NettyConstant;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class ClientSocketInitializer extends ChannelInitializer<SocketChannel> {

    private final ClientSocketHandler handler;

    public ClientSocketInitializer(ClientSocketHandler handler) {
        this.handler = handler;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        //以下三个是Http的支持
        //http解码器
        pipeline.addLast(new HttpClientCodec());
//        //支持写大数据流
        pipeline.addLast(new ChunkedWriteHandler());
        //http聚合器
        pipeline.addLast(new HttpObjectAggregator(65536));
        // 心跳包
        pipeline.addLast(new IdleStateHandler(0, NettyConstant.WRITER_IDLE_TIME, 0, TimeUnit.SECONDS));
        // 自定义消息接收器
        pipeline.addLast(handler);
    }
}