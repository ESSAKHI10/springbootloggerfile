package com.example.logtestapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
/*
 * this class allows us to add our created intercepter 
 * logIntercepter  
 */
@Component
public class CustomWebConfigurer implements WebMvcConfigurer {

    @Autowired
    private InterceptLog logInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
    }
}