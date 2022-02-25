package com.tequeno.bootassembly.netty.client;

import com.tequeno.bootassembly.netty.NettyConstant;
import com.tequeno.bootassembly.netty.NettyRequest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;

@Service
public class ClientChannelService {

    @Resource
    private ThreadPoolTaskExecutor pool;

    public void start() throws Exception {
        if (ClientSocket.isRunning()) {
            return;
        }
        System.out.println("client-------------Start");
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        pool.execute((() -> ClientSocket.start(hostAddress, NettyConstant.PORT)));
    }

    public void close() {
        if (!ClientSocket.isRunning()) {
            return;
        }
        System.out.println("client-------------Close");
        ClientSocket.close();
    }

    public void send(NettyRequest request) {
        if (!ClientSocket.isRunning()) {
            return;
        }
        ClientSocket.send(request);
    }
}