package com.tequeno.bootassembly.netty.server;

import com.alibaba.fastjson.JSON;
import com.tequeno.bootassembly.netty.NettyConstant;
import com.tequeno.bootassembly.netty.NettyKeyEnum;
import com.tequeno.bootassembly.netty.NettyResponse;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 服务 链接 管理
 */
public class ServerSocket {

    private static ServerSocket singleInstance = null;

    private static ServerSocket getInstance() {
        if (singleInstance == null) {
            synchronized (ServerSocket.class) {
                if (singleInstance == null) {
                    singleInstance = new ServerSocket();
                }
            }
        }
        return singleInstance;
    }


    /**
     * 管理当前服务节点内所有已连接的channel
     */
    private ChannelGroup clientChannelGroup;

    /**
     * 服务节点
     */
    private Channel serverChannel;

    public static boolean isRunning() {
        return null != getInstance().serverChannel;
    }

    public static void start(int port) {
        getInstance().run(port);
    }

    public static void close() {
        getInstance().serverChannel.close();
    }

    public static String serverChannelId() {
        return getInstance().serverChannel.id().asLongText();
    }

    public static void addClientChannel(Channel channel) {
        getInstance().clientChannelGroup.add(channel);
    }

    public static void removeClientChannel(Channel channel) {
        getInstance().clientChannelGroup.remove(channel);
    }

    public static List<Map<String, Object>> clientChannelStatus() {
        return getInstance().clientChannelGroup.stream()
                .map(ctx -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("channelId", ctx.id().asLongText());
                    map.put("registered", ctx.isRegistered());
                    map.put("localAddress", ctx.localAddress());
                    map.put("remoteAddress", ctx.remoteAddress());

                    NettyKeyEnum.map().keySet()
                            .stream()
                            .map(AttributeKey::valueOf)
                            .filter(ctx::hasAttr)
                            .forEach(k -> map.put(k.name(), ctx.attr(k).get()));
                    return map;
                }).collect(Collectors.toList());
    }

    // 给单channel发送消息
    public static void sendMsg(NettyResponse msg, ChannelHandlerContext ctx) {
        ctx.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(msg)));
    }

    // 按条件匹配channel发送消息
    public static void sendMsg(NettyResponse response, ChannelMatcher matcher) {
        getInstance().clientChannelGroup.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(response)), matcher);
    }

    private void run(int port) {
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new ServerSocketInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync(); // (7)

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            serverChannel = f.channel();
            clientChannelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
            System.out.println("server-------------closeFuture");
            serverChannel.closeFuture().sync();
            System.out.println("server-------------sync");
        } catch (Exception e) {
            System.out.println("server-------------启动netty异常");
        } finally {
            System.out.println("server-------------workerGroup shutdown gracefully");
            workerGroup.shutdownGracefully();
            System.out.println("server-------------bossGroup shutdown gracefully");
            bossGroup.shutdownGracefully();
            System.out.println("server-------------end");
            clientChannelGroup = null;
            serverChannel = null;
        }
    }

    public static void main(String[] args) {
        start(NettyConstant.PORT);
    }
}