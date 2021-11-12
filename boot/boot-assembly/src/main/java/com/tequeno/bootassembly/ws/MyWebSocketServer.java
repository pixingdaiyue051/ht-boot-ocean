package com.tequeno.bootassembly.ws;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class MyWebSocketServer {

    private static Channel SERVER_CHANNEL = null;

    private static Integer PORT = null;

    public static void start() {
        if (null != SERVER_CHANNEL) {
            return;
        }
        PORT = 7517;
        run();
    }

    public static void close() {
        if (null == SERVER_CHANNEL) {
            return;
        }
        SERVER_CHANNEL.close();
        SERVER_CHANNEL = null;
    }

    private static void run() {
        Thread wsServerThread = new Thread(() -> {
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
                ChannelFuture f = b.bind(PORT).sync(); // (7)

                // Wait until the server socket is closed.
                // In this example, this does not happen, but you can do that to gracefully
                // shut down your server.
                SERVER_CHANNEL = f.channel();
                System.out.println("closeFuture");
                SERVER_CHANNEL.closeFuture().sync();
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
        });

        wsServerThread.setName("wsServerThread");
        wsServerThread.setDaemon(true);
        wsServerThread.start();
    }
}
