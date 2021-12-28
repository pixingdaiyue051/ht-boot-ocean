package com.tequeno.bootassembly.ws.client;


import com.alibaba.fastjson.JSON;
import com.tequeno.bootassembly.ws.NettyRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.List;

public class MyClientEncoder extends MessageToMessageEncoder<NettyRequest> {

    @Override
    protected void encode(ChannelHandlerContext ctx, NettyRequest request, List<Object> list) throws Exception {
        System.out.println("MyClientEncoder----------------" + request);
        list.add(new TextWebSocketFrame(JSON.toJSONString(request)));
    }

}