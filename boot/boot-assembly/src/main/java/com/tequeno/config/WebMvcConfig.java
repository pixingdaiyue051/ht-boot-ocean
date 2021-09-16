package com.tequeno.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhangshuai
 * @Description MVC配置
 * Create on 2020/12/30
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * @Author zhangshuai
     * @Description //跨域
     * @Date 15:08 2020/12/30
     **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }

}
