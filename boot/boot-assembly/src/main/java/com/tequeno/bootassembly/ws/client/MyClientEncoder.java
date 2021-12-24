package com.tequeno.bootassembly.ws.client;


import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.List;

public class MyClientEncoder extends MessageToMessageEncoder<String> {

    @Override
    protected void encode(ChannelHandlerContext ctx, String s, List<Object> list) throws Exception {
        System.out.println("MyClientEncoder----------------" + s);
        String s1 = JSON.toJSONString(new TextWebSocketFrame(s));
        list.add(s1);
    }

}