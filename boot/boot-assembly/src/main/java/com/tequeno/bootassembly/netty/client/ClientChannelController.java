package com.tequeno.bootassembly.netty.client;

import com.tequeno.bootassembly.netty.NettyRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@RestController
public class ClientChannelController {

    @Resource
    private ClientChannelService clientService;

    @RequestMapping("/client/start")
    public void start() throws Exception {
        clientService.start();
    }

    @PostMapping("/client/close")
    @PreDestroy
    public void close() throws Exception {
        clientService.close();
    }

    @PostMapping("/client/send")
    public void send(@RequestBody(required = false) NettyRequest request) {
        clientService.send(request);
    }
}