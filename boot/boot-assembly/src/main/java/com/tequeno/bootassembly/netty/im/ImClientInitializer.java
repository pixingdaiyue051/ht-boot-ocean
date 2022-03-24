package com.tequeno.bootassembly.netty.im;

import com.tequeno.bootassembly.netty.protobuf.Wrapper;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

public class ImClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(
//                new StringDecoder(),
//                new StringEncoder(),
//                new MyClientHandler(),
                new ProtobufEncoder(),
                new ProtobufDecoder(Wrapper.getDefaultInstance()),
                new ImClientProtobufHandler()
        );
    }
}