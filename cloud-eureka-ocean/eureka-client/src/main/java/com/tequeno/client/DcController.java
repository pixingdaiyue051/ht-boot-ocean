package com.tequeno.eurekaclient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 打印已经注册了的服务
     * @return
     */
    @GetMapping("/dc")
    public String dc(){
        String msg = "services:" + discoveryClient.getServices();
        System.out.println(msg);
        return msg;
    }
}
