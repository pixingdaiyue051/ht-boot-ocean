//package com.tequeno.bootassembly;
//
//import org.springframework.stereotype.Component;
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicInteger;
//
//@ServerEndpoint(value = "/ws")
//@Component
//public class SpringWebSocketController {
//
//    /**
//     * 记录当前在线连接数
//     */
//    public static AtomicInteger onlineCount = new AtomicInteger(0);
//
//    /**
//     * 存放所有在线的客户端
//     */
//    public static Map<String, Session> clients = new ConcurrentHashMap<>();
//
//    /**
//     * 连接建立成功调用的方法
//     */
//    @OnOpen
//    public void onOpen(Session session) {
//        clients.put(session.getId(), session);
//        onlineCount.incrementAndGet();
//        System.out.println(session.getBasicRemote() + "上线了!");
//        System.out.println("目前在线数" + onlineCount.get());
//    }
//
//    /**
//     * 连接关闭调用的方法
//     */
//    @OnClose
//    public void onClose(Session session) {
//        clients.remove(session.getId());
//        onlineCount.decrementAndGet();
//        System.out.println(session.getBasicRemote() + "断开连接!");
//        System.out.println("目前在线数" + onlineCount.get());
//    }
//
//    /**
//     * 收到客户端消息后调用的方法
//     *
//     * @param message 客户端发送过来的消息
//     */
//    @OnMessage
//    public void onMessage(String message, Session session) throws Exception {
//        System.out.println(message);
////        JSONObject jsonObject = JSON.parseObject(message);
////        session.getUserProperties().put();
//        session.getBasicRemote().sendText("heart beat");
//    }
//
//    @OnError
//    public void onError(Session session, Throwable error) {
//        error.printStackTrace();
//    }
//
//}