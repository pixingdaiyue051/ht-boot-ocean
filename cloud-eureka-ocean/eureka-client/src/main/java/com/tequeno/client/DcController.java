package com.tequeno.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 打印已经注册了的服务
     * @return
     */
    @RequestMapping("/dc")
    public String dc(){
        String msg = "services:" + discoveryClient.getServices();
        System.out.println(msg);
        return msg;
    }
}
