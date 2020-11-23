//package com.tequeno.config.ES;
//
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//@Configuration
//public class EsConfig {
//    @Bean
//    public TransportClient createTransportClient() throws UnknownHostException {
//        // 创建主节点,es默认的tcp连接端口是9300
//        TransportAddress mainNode = new TransportAddress(
//                InetAddress.getByName("localhost"), 9300
//        );
//        TransportAddress node1 = new TransportAddress(
//                InetAddress.getByName("localhost"), 9301
//        );
//        TransportAddress node2 = new TransportAddress(
//                InetAddress.getByName("localhost"), 9302
//        );
//        TransportAddress node3 = new TransportAddress(
//                InetAddress.getByName("localhost"), 9303
//        );
//
//        // es配置
//        Settings settings = Settings.builder()
//                .put("cluster.name", "myes")
//                .build();
//        TransportClient client = new PreBuiltTransportClient(settings);
//        client.addTransportAddresses(mainNode, node1, node2, node3);
//        return client;
//    }
//}