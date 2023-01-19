package com.example.logtestapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@Configuration
public class ConfigurationBeans {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
