package com.tequeno.bootassembly.ws.server;

import com.tequeno.bootassembly.ws.NettyResponse;
import com.tequeno.bootassembly.ws.NettyResponseHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ChannelService {

    @Resource
    private ThreadPoolTaskExecutor pool;

    @Value("${ws.port}")
    private Integer wsPort;

    public void serverStart() throws Exception {
        if (MyWebSocketServer.isRunning()) {
            return;
        }
        System.out.println("Starting MyWebSocket");
        pool.execute((() -> MyWebSocketServer.start(wsPort)));
    }

    public void serverClose() {
        if (!MyWebSocketServer.isRunning()) {
            return;
        }
        System.out.println("Closing MyWebSocket");
        MyWebSocketServer.close();
    }

    public NettyResponse status() {
        if (MyWebSocketServer.isRunning()) {
            List<Map<String, Object>> list = MyWebSocketServer.clientChannelStatus();
            return NettyResponseHandler.success(String.format("%s channels is connecting", list.size()), list);
        }
        return NettyResponseHandler.fail("server is down");
    }
}