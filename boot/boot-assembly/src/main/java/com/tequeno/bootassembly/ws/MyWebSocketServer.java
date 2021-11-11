package com.tequeno.bootassembly.ws;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/ws")
@Component
public class MyWebSocketServer {

    /**
     * 记录当前在线连接数
     */
    public static AtomicInteger onlineCount = new AtomicInteger(0);

    /**
     * 存放所有在线的客户端
     */
    public static Map<String, Session> clients = new ConcurrentHashMap<>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        clients.put(session.getId(), session);
        onlineCount.incrementAndGet();
        System.out.println(session.getBasicRemote() + "上线了!");
        System.out.println("目前在线数" + onlineCount.get());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        clients.remove(session.getId());
        onlineCount.decrementAndGet();
        System.out.println(session.getBasicRemote() + "断开连接!");
        System.out.println("目前在线数" + onlineCount.get());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println(message);
        MyWebSocketRequest request = JSON.parseObject(message, MyWebSocketRequest.class);
        if (MyWebSocketCodeEnum.HEART.getCode().equals(request.getCode())) {
            System.out.println("收到心跳包");
            sendMessage("heart beat", session);
        }
        if (MyWebSocketCodeEnum.SUB.getCode().equals(request.getCode())) {
            System.out.println("收到订阅包");
            session.getUserProperties().put(request.getKey(), request.getValue());
            sendMessage("hello welcome", session);
        }
        if (MyWebSocketCodeEnum.BIZ.getCode().equals(request.getCode())) {
            System.out.println("收到业务包");
            sendMessage(request.getMsg(), session);
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 服务端发送消息给客户端
     */
    private void sendMessage(String message, Session toSession) {
        try {
            toSession.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}