package com.tequeno.bootassembly.ws.client;

import com.alibaba.fastjson.JSON;
import com.tequeno.bootassembly.ws.NettyCodeEnum;
import com.tequeno.bootassembly.ws.NettyRequestHandler;
import com.tequeno.bootassembly.ws.NettyResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

public class MyClientHandler extends SimpleChannelInboundHandler<Object> {

    private WebSocketClientHandshaker handshaker;

    public MyClientHandler(WebSocketClientHandshaker handshaker) {
        this.handshaker = handshaker;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("MyClientHandler------------" + msg);
        System.out.println("isHandshakeComplete-----------" + handshaker.isHandshakeComplete());
        if (!handshaker.isHandshakeComplete()) {
            handshaker.finishHandshake(ctx.channel(), (FullHttpResponse) msg);
            ctx.writeAndFlush(NettyRequestHandler.wrap(NettyCodeEnum.IM_USER_ONLINE, 1466227820597370881L));
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
        System.out.println("MyClientHandler-----channelActive");
        handshaker.handshake(ctx.channel());
    }


    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler-----channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
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
        if (evt instanceof IdleStateEvent) {
            IdleState state = ((IdleStateEvent) evt).state();
            if (IdleState.WRITER_IDLE.equals(state)) {
                ctx.writeAndFlush(NettyRequestHandler.heartBeat());
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

}