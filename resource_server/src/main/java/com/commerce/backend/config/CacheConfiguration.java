package com.commerce.backend.config;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfiguration extends CachingConfigurerSupport {

    @Bean
    @Override
    public CacheManager cacheManager() {
        com.github.benmanes.caffeine.cache.Cache<Object, Object> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.HOURS)
                .maximumSize(1000)
                .build();

        return new org.springframework.cache.caffeine.CaffeineCacheManager() {
            protected com.github.benmanes.caffeine.cache.Cache<Object, Object> createNativeCaffeineCache() {
                return cache;
            }
        };
    }
}

