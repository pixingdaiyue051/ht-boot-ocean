package com.tequeno.bootassembly.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ws")
public class NettyWebSocketStarter {

    @RequestMapping("start")
    public void start() {
        MyWebSocketServer.start();
    }

    @RequestMapping("close")
    public void close() {
        // 1.直接使用serverChannel关闭
//        MyWebSocketServer.close();
        // 2.从连接池中活跃channel获取serverChannel关闭,前提是已经有活跃的channel
        MyWebSocketHandler.channelGroup.stream()
                .findAny()
                .ifPresent(item -> item.parent().close());
    }
}
