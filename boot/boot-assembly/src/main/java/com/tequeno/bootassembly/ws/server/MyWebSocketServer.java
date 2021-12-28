package com.tequeno.bootassembly.ws.server;

import com.alibaba.fastjson.JSON;
import com.tequeno.bootassembly.ws.NettyResponse;
import com.tequeno.bootassembly.ws.WebSocketKeyEnum;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
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
public class MyWebSocketServer {

    private static MyWebSocketServer singleInstance = null;

    private static MyWebSocketServer getInstance() {
        if (singleInstance == null) {
            synchronized (MyWebSocketServer.class) {
                if (singleInstance == null) {
                    singleInstance = new MyWebSocketServer();
                    singleInstance.clientChannelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
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
        MyWebSocketServer instance = getInstance();
        instance.clientChannelGroup.clear();
        instance.serverChannel.close();
        instance.serverChannel = null;
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

                    WebSocketKeyEnum.map().keySet()
                            .stream()
                            .map(AttributeKey::valueOf)
                            .filter(ctx::hasAttr)
                            .forEach(k -> map.put(k.name(), ctx.attr(k).get()));
                    return map;
                }).collect(Collectors.toList());
    }

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
                    .childHandler(new MyWebSocketServerInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            // Bind and start to accept incoming connections.
            ChannelFuture f = b.bind(port).sync(); // (7)

            // Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            serverChannel = f.channel();
            System.out.println("closeFuture");
            serverChannel.closeFuture().sync();
            System.out.println("sync");
        } catch (Exception e) {
            System.out.println("启动netty异常");
        } finally {
            System.out.println("workerGroup shutdown gracefully");
            workerGroup.shutdownGracefully();
            System.out.println("bossGroup shutdown gracefully");
            bossGroup.shutdownGracefully();
            System.out.println("end");
        }
    }

    public static void main(String[] args) {
        MyWebSocketServer.start(7132);
    }
}