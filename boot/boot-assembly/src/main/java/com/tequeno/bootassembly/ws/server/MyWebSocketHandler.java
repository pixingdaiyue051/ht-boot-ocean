package com.tequeno.bootassembly.ws.server;

import com.alibaba.fastjson.JSON;
import com.tequeno.bootassembly.ws.NettyCodeEnum;
import com.tequeno.bootassembly.ws.NettyRequest;
import com.tequeno.bootassembly.ws.NettyResponse;
import com.tequeno.bootassembly.ws.NettyResponseHandler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MyWebSocketHandler extends SimpleChannelInboundHandler<Object> {

    private final static String PATH = "/data/doc/ws/";

    //接收到客户都发送的消息
    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof TextWebSocketFrame) {
            textMsgHandler(ctx, (TextWebSocketFrame) msg);
        } else if (msg instanceof BinaryWebSocketFrame) {
            binaryMsgHandler(ctx, (BinaryWebSocketFrame) msg);
        } else {
            System.out.println("暂不支持 " + msg);
            sendMessage(ctx, NettyResponseHandler.fail("暂不支持"));
        }
    }


    //客户端建立连接
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyWebSocketServer.addClientChannel(ctx.channel());
    }

    //关闭连接
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        MyWebSocketServer.removeClientChannel(ctx.channel());
    }

    //出现异常
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

    //给单个人发送消息
    private void sendMessage(ChannelHandlerContext ctx, NettyResponse msg) {
        ctx.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(msg)));
    }

    private void textMsgHandler(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        String temp = msg.text();
        NettyRequest request = JSON.parseObject(temp, NettyRequest.class);
        if (NettyCodeEnum.HEART.getCode().equals(request.getCode())) {
            System.out.println("收到心跳包");
            sendMessage(ctx, NettyResponseHandler.success(NettyCodeEnum.HEART));
        }
        if (NettyCodeEnum.SUB.getCode().equals(request.getCode())) {
            System.out.println("收到订阅包");
            String key = request.getKey();
            AttributeKey<Object> attributeKey = AttributeKey.valueOf(key);
            ctx.channel().attr(attributeKey).set(request.getValue());
            sendMessage(ctx, NettyResponseHandler.success(NettyCodeEnum.SUB));
        }
        if (NettyCodeEnum.BIZ.getCode().equals(request.getCode())) {
            System.out.println("收到业务包");
            sendMessage(ctx, NettyResponseHandler.success(NettyCodeEnum.BIZ));
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

            sendMessage(ctx, NettyResponseHandler.success());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}