package com.tequeno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
//@EnableScheduling
public class BootAssemblyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootAssemblyApplication.class, args);
    }

}
