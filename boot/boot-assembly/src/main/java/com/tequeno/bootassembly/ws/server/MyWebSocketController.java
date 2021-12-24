package com.tequeno.bootassembly.ws.server;


import com.tequeno.bootassembly.ws.NettyResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@RestController
public class MyWebSocketController implements CommandLineRunner {

    @Resource
    private ChannelService channelService;

    @Override
    @RequestMapping("/ws/start")
    public void run(String... args) throws Exception {
        channelService.serverStart();
    }

    @PostMapping("/ws/close")
    @PreDestroy
    public void close() throws Exception  {
        channelService.serverClose();
    }

    @RequestMapping("/ws/status")
    public NettyResponse status() throws Exception {
        return channelService.status();
    }
}
