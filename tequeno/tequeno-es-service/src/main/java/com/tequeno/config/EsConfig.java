package com.tequeno.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Desription:
 * @Author: hexk
 */
@Configuration
public class EsConfig {

    private final static Logger logger = LoggerFactory.getLogger(EsConfig.class);

    @Bean
    public RestHighLevelClient restHighLevelClientBuild() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.3.64", 9200, "http"),
                        new HttpHost("192.168.3.64", 9201, "http"),
                        new HttpHost("192.168.3.64", 9202, "http")
                )
        );
    }
}
