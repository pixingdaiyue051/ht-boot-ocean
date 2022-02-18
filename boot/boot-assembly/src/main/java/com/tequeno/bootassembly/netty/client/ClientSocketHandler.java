package com.tequeno.bootassembly.netty.client;

import com.alibaba.fastjson.JSON;
import com.tequeno.bootassembly.netty.NettyRequestHandler;
import com.tequeno.bootassembly.netty.NettyResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.timeout.IdleStateEvent;

public class ClientSocketHandler extends SimpleChannelInboundHandler<Object> {

    private final WebSocketClientHandshaker handshaker;

    public ClientSocketHandler(WebSocketClientHandshaker handshaker) {
        this.handshaker = handshaker;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client------------" + msg);
        if (!handshaker.isHandshakeComplete()) {
            handshaker.finishHandshake(ctx.channel(), (FullHttpResponse) msg);
        } else if (msg instanceof TextWebSocketFrame) {
            TextWebSocketFrame socketFrame = (TextWebSocketFrame) msg;
            String text = socketFrame.text();
            NettyResponse res = JSON.parseObject(text, NettyResponse.class);
            System.out.println(res);
        } else {
            System.out.println("暂不支持");
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client-----channelActive");
        handshaker.handshake(ctx.channel());
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client-----channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
    }

    /**
     * readerIdleTime 读空闲时间  当前 channel 的 channelRead 方法在 readerIdleTime 时间内未收到任何消息则触发一次 userEventTrigger
     * writerIdleTime 写空闲时间  当前 channel 的 write 方法在 writerIdleTime 时间内未发送任何消息则触发一次 userEventTrigger
     * allIdleTime 写空闲时间  当前 channel 在 allIdleTime 时间内未发送任何消息或内未收到任何消息则触发一次 userEventTrigger
     *
     * @param ctx writerIdleTime
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("client------------userEventTriggered");
        if (evt instanceof IdleStateEvent) {
            ClientSocket.send(NettyRequestHandler.heartBeat(), ctx);
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}