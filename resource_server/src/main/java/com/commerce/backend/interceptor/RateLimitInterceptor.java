package com.commerce.backend.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    private static final int MAX_REQUESTS = 10; // Número máximo de solicitações permitidas
    private static final long TIME_INTERVAL = 60000; // Intervalo de tempo em milissegundos (1 minuto)
    private static final Map<String, Queue<Long>> requestMap = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String ip = request.getRemoteAddr();
        Queue<Long> requests = requestMap.computeIfAbsent(ip, k -> new LinkedList<>());

        System.out.println(ip);
        System.out.println(ip);
        System.out.println(ip);
        System.out.println(ip);
        System.out.println(ip);
        System.out.println(ip);
        System.out.println(ip);
        System.out.println(ip);
        System.out.println(ip);
        System.out.println(ip);
        System.out.println(ip);
        System.out.println(ip);
        System.out.println(ip);


        // Remova as solicitações mais antigas do mapa
        long currentTime = System.currentTimeMillis();
        while (!requests.isEmpty() && currentTime - requests.peek() > TIME_INTERVAL) {
            requests.poll();
        }

        // Verifique se o limite de solicitações foi excedido
        if (requests.size() >= MAX_REQUESTS) {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            return false; // Bloqueia a execução do endpoint
        }

        // Registre a nova solicitação
        requests.offer(currentTime);
        return true; // Permite a execução do endpoint
    }
}
