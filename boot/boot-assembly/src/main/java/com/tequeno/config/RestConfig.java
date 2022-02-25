package com.tequeno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class RestConfig implements WebMvcConfigurer {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(20971520);   // 20MB
        multipartResolver.setMaxInMemorySize(1048576);  // 1MB
        return multipartResolver;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/demo/**")
//                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                .maxAge(3600)
//                .allowCredentials(true)
//                .allowedOrigins("*")
        ;
    }

//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }
}
