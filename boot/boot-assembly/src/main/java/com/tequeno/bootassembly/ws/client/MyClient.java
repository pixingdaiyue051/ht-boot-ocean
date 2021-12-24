package com.tequeno.bootassembly.ws.client;

import com.tequeno.bootassembly.ws.server.MyWebSocketServer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {

    private static MyClient singleInstance = null;

    private static MyClient getInstance() {
        if (singleInstance == null) {
            synchronized (MyWebSocketServer.class) {
                if (singleInstance == null) {
                    singleInstance = new MyClient();
                }
            }
        }
        return singleInstance;
    }

    /**
     * 当前链接的channel
     */
    private Channel channel;

    public static boolean isRunning() {
        return null != getInstance().channel;
    }

    public static void start(String host, int port) {
        getInstance().run(host, port);
    }

    public static void close() {
        MyClient instance = getInstance();
        instance.channel.close();
        instance.channel = null;
    }

    public void run(String host, int port) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new MyClientInitializer());

            // Start the client.
            ChannelFuture f = b.connect(host, port).sync(); // (5)

            // Wait until the connection is closed.
            channel = f.channel();
            System.out.println("closeFuture");
            channel.closeFuture().sync();
            System.out.println("sync");
        } catch (Exception e) {
            System.out.println("启动netty异常");
        } finally {
            System.out.println("workerGroup shutdown gracefully");
            workerGroup.shutdownGracefully();
            System.out.println("end");
        }
    }

    public static void main(String[] args) {
        MyClient.start("127.0.0.1", 7517);
    }
}