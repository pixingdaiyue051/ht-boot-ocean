package com.tequeno.bootassembly.netty.server;

import com.tequeno.bootassembly.netty.NettyResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@RestController
public class ServerChannelController implements CommandLineRunner {

    @Resource
    private ServerChannelService channelService;

    @Override
    @RequestMapping("/server/start")
    public void run(String... args) {
        channelService.start();
    }

    @PostMapping("/server/close")
    @PreDestroy
    public void close() {
        channelService.close();
    }

    @RequestMapping("/server/status")
    public NettyResponse status() {
        return channelService.status();
    }
}
