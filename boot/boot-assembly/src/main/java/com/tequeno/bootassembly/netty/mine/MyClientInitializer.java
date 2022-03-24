package com.tequeno.bootassembly.netty.mine;

import com.tequeno.bootassembly.netty.protobuf.Wrapper;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(
//                new ProtobufEncoder(),
//                new ProtobufDecoder(Wrapper.getDefaultInstance()),
                new MyEncoder(),
                new MyDecoder(),
                new MyClientHandler()
        );
    }
}