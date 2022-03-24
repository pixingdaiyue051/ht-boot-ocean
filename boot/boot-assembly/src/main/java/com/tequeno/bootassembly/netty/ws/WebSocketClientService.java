package com.tequeno.bootassembly.netty.ws;

import com.tequeno.bootassembly.netty.NettyConstant;
import com.tequeno.bootassembly.netty.NettyRequest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;

@Service
public class WebSocketClientService {

    @Resource
    private ThreadPoolTaskExecutor pool;

    public void start() throws Exception {
        if (WebSocketClient.isRunning()) {
            return;
        }
        System.out.println("client-------------Start");
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        pool.execute((() -> WebSocketClient.start(hostAddress, NettyConstant.PORT)));
    }

    public void close() {
        if (!WebSocketClient.isRunning()) {
            return;
        }
        System.out.println("client-------------Close");
        WebSocketClient.close();
    }

    public void send(NettyRequest request) {
        if (!WebSocketClient.isRunning()) {
            return;
        }
        WebSocketClient.send(request);
    }
}