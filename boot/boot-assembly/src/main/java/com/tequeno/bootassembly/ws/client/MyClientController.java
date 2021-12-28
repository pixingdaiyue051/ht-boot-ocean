package com.tequeno.bootassembly.ws.client;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@RestController
public class MyClientController {

    @Resource
    private ClientService clientService;

    @RequestMapping("/client/start")
    public void start() throws Exception {
        clientService.start();
    }

    @PostMapping("/client/close")
    @PreDestroy
    public void close() throws Exception {
        clientService.close();
    }
}