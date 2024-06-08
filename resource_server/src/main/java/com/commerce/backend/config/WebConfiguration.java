package com.commerce.backend.config;

import com.commerce.backend.interceptor.RateLimiterInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private final RateLimiterInterceptor rateLimiterInterceptor;

    @Autowired
    public WebConfiguration(RateLimiterInterceptor rateLimiterInterceptor) {
        this.rateLimiterInterceptor = rateLimiterInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rateLimiterInterceptor).addPathPatterns("/product/search");
        registry.addInterceptor(rateLimiterInterceptor).addPathPatterns("/account/registration");
    }
}
