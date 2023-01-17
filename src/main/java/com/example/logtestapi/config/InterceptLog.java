package com.example.logtestapi.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.logtestapi.Service.ILoginSerivce;

@Component
public class InterceptLog implements HandlerInterceptor {

    @Autowired
    ILoginSerivce loggingService;

    /*
     * handl methodes without payloud {delete put get }
     * set the body null 
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request.getMethod().equals(HttpMethod.GET.name())
                || request.getMethod().equals(HttpMethod.DELETE.name())
                || request.getMethod().equals(HttpMethod.PUT.name())) {
            loggingService.displayReq(request, null);
        }
        return true;
    }
}