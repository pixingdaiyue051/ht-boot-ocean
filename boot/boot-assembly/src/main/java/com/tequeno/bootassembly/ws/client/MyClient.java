package com.tequeno.bootassembly.ws.client;

import com.tequeno.bootassembly.ws.server.MyWebSocketServer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;

import java.net.URI;

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
            URI uri = new URI(String.format("ws://%s:%d/ws", host, port));
            WebSocketClientHandshaker handshaker = WebSocketClientHandshakerFactory.newHandshaker(uri, WebSocketVersion.V13, null, false, new DefaultHttpHeaders());
            MyClientHandler handler = new MyClientHandler(handshaker);
            MyClientInitializer initializer = new MyClientInitializer(handler);

            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(initializer);

            // Start the client.
            ChannelFuture f = b.connect(host, port).sync(); // (5)
            // Wait until the connection is closed.
            channel = f.channel();

            System.out.println("client-------------closeFuture");
            channel.closeFuture().sync();
            System.out.println("client-------------sync");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("client-------------启动netty异常");
        } finally {
            System.out.println("client-------------workerGroup shutdown gracefully");
            workerGroup.shutdownGracefully();
            System.out.println("client-------------end");
        }
    }

    public static void main(String[] args) {
        start("127.0.0.1", 7132);
    }
}