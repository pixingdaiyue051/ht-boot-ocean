package com.tequeno.bootassembly.ws.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.InetAddress;

@Service
public class ClientService {

    @Resource
    private ThreadPoolTaskExecutor pool;

    @Value("${ws.port}")
    private Integer wsPort;

    public void start() throws Exception {
        if (MyClient.isRunning()) {
            return;
        }
        System.out.println("client-------------Starting MyWebSocket");
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        pool.execute((() -> MyClient.start(hostAddress, 80)));
    }

    public void close() {
        if (!MyClient.isRunning()) {
            return;
        }
        System.out.println("client-------------Closing MyWebSocket");
        MyClient.close();
    }
}