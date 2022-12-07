package com.enigmacamp.myjwt.configuration;

import com.enigmacamp.myjwt.controllers.interceptor.MyHandlerInterceptor;
import com.enigmacamp.myjwt.controllers.interceptor.SimpleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Autowired
    SimpleInterceptor simpleInterceptor;

    @Autowired
    MyHandlerInterceptor myHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleInterceptor);
        registry.addInterceptor(myHandlerInterceptor);
    }
}
