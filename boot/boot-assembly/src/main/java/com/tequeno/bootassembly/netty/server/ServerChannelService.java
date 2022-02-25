package com.tequeno.bootassembly.netty.server;

import com.tequeno.bootassembly.netty.NettyConstant;
import com.tequeno.bootassembly.netty.NettyResponse;
import com.tequeno.bootassembly.netty.NettyResponseHandler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ServerChannelService {

    @Resource
    private ThreadPoolTaskExecutor pool;

    public void start() {
        if (ServerSocket.isRunning()) {
            return;
        }
        System.out.println("server-------------Start");
        pool.execute((() -> ServerSocket.start(NettyConstant.PORT)));
    }

    public void close() {
        if (!ServerSocket.isRunning()) {
            return;
        }
        System.out.println("server-------------Close");
        ServerSocket.close();
    }

    public NettyResponse status() {
        if (ServerSocket.isRunning()) {
            List<Map<String, Object>> list = ServerSocket.clientChannelStatus();
            return NettyResponseHandler.success(String.format("%s channels is connecting", list.size()), list);
        }
        return NettyResponseHandler.fail("server is down");
    }
}