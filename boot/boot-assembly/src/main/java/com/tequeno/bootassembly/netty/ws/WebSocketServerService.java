package com.tequeno.bootassembly.netty.ws;

import com.tequeno.bootassembly.netty.NettyConstant;
import com.tequeno.bootassembly.netty.NettyResponse;
import com.tequeno.bootassembly.netty.NettyResponseHandler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class WebSocketServerService {

    @Resource
    private ThreadPoolTaskExecutor pool;

    public void start() {
        if (WebSocketServer.isRunning()) {
            return;
        }
        System.out.println("server-------------Start");
        pool.execute((() -> WebSocketServer.start(NettyConstant.PORT)));
    }

    public void close() {
        if (!WebSocketServer.isRunning()) {
            return;
        }
        System.out.println("server-------------Close");
        WebSocketServer.close();
    }

    public NettyResponse status() {
        if (WebSocketServer.isRunning()) {
            List<Map<String, Object>> list = WebSocketServer.clientChannelStatus();
            return NettyResponseHandler.success(String.format("%s channels is connecting", list.size()), list);
        }
        return NettyResponseHandler.fail("server is down");
    }
}