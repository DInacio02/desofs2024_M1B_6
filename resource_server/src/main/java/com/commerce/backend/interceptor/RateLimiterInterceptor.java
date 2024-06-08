package com.commerce.backend.interceptor;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
public class RateLimiterInterceptor implements HandlerInterceptor {

    private final Cache<String, Bucket> cache;

    public RateLimiterInterceptor() {
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.HOURS)
                .maximumSize(1000)
                .build();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String ip = request.getRemoteAddr();
        Bucket bucket = cache.get(ip, k -> createNewBucket());

        if (bucket.tryConsume(1)) {
            return true;
        } else {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            return false;
        }
    }

    private Bucket createNewBucket() {
        Bandwidth limit = Bandwidth.classic(100, Refill.greedy(100, Duration.ofMinutes(1)));
        return Bucket4j.builder().addLimit(limit).build();
    }
}
