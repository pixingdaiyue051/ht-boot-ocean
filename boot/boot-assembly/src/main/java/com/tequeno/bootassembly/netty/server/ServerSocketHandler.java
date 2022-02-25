package com.tequeno.bootassembly.netty.server;

import com.alibaba.fastjson.JSON;
import com.tequeno.bootassembly.netty.NettyCodeEnum;
import com.tequeno.bootassembly.netty.NettyConstant;
import com.tequeno.bootassembly.netty.NettyRequest;
import com.tequeno.bootassembly.netty.NettyResponseHandler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ServerSocketHandler extends SimpleChannelInboundHandler<Object> {

    private final static String PATH = "/data/doc/ws/";

    //接收到客户都发送的消息
    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server-----" + msg);
        if (msg instanceof TextWebSocketFrame) {
            textMsgHandler(ctx, (TextWebSocketFrame) msg);
        } else if (msg instanceof BinaryWebSocketFrame) {
            binaryMsgHandler(ctx, (BinaryWebSocketFrame) msg);
        } else {
            ServerSocket.sendMsg(NettyResponseHandler.fail("暂不支持"), ctx);
        }
    }


    //客户端建立连接
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server-----channelActive");
        ctx.channel().attr(NettyConstant.ATTR_READ_IDLE).set(0);
        ServerSocket.addClientChannel(ctx.channel());
    }

    //关闭连接
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server-----channelInactive");
        ServerSocket.removeClientChannel(ctx.channel());
    }

    //出现异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    private void textMsgHandler(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        String temp = msg.text();
        NettyRequest request = JSON.parseObject(temp, NettyRequest.class);
        if (NettyCodeEnum.HEART.getCode().equals(request.getCode())) {
            System.out.println("收到心跳包");
            ServerSocket.sendMsg(NettyResponseHandler.success(NettyCodeEnum.HEART), ctx);
        }
        if (NettyCodeEnum.SUB.getCode().equals(request.getCode())) {
            System.out.println("收到订阅包");
            String key = request.getKey();
            AttributeKey<Object> attributeKey = AttributeKey.valueOf(key);
            ctx.channel().attr(attributeKey).set(request.getValue());
            ServerSocket.sendMsg(NettyResponseHandler.success(NettyCodeEnum.SUB), ctx);
        }
        if (NettyCodeEnum.BIZ.getCode().equals(request.getCode())) {
            System.out.println("收到业务包");
            ServerSocket.sendMsg(NettyResponseHandler.success(NettyCodeEnum.BIZ), ctx);
        }
    }

    private void binaryMsgHandler(ChannelHandlerContext ctx, BinaryWebSocketFrame msg) {
        try (FileChannel fileChannel = FileChannel.open(Paths.get(PATH, System.currentTimeMillis() + ".jpg"),
                StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {

            ByteBuf in = msg.content();
            int len = in.readableBytes();
            byte[] bytes = new byte[len];
            in.readBytes(bytes);
            ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
            fileChannel.write(byteBuffer);
            byteBuffer.clear();

            ServerSocket.sendMsg(NettyResponseHandler.success(), ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        System.out.println("server-----userEventTriggered-----" + evt);
        if (evt instanceof IdleStateEvent) {
            Attribute<Object> attribute = ctx.channel().attr(NettyConstant.ATTR_READ_IDLE);
            int i = Integer.parseInt(attribute.get().toString());
            if (++i < NettyConstant.MAX_IDLE_TIMES) {
                attribute.set(i);
                return;
            }
            ctx.close();
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}