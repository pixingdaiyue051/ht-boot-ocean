package com.tequeno.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用eureka-client的同名服务，打印已经注册的服务
     * @return
     */
    @RequestMapping("/dc")
    public String dc(){
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }
}
