package com.commerce.oauth.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitFilter implements Filter {

    private static final int MAX_REQUESTS = 10; // Número máximo de solicitações permitidas
    private static final long TIME_INTERVAL = 60000; // Intervalo de tempo em milissegundos (1 minuto)
    private static final Map<String, Queue<Long>> requestMap = new ConcurrentHashMap<>();

    private static final Logger logger = LoggerFactory.getLogger(RateLimitFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialização se necessário
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String ip = request.getRemoteAddr();
        logger.info("Request from IP: " + ip); // Log IP address

        Queue<Long> requests = requestMap.computeIfAbsent(ip, k -> new LinkedList<>());

        // Remova as solicitações mais antigas do mapa
        long currentTime = System.currentTimeMillis();
        while (!requests.isEmpty() && currentTime - requests.peek() > TIME_INTERVAL) {
            requests.poll();
        }

        // Verifique se o limite de solicitações foi excedido
        if (requests.size() >= MAX_REQUESTS) {
            logger.info("IP " + ip + " exceeded the rate limit."); // Log rate limit exceedance
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            return; // Bloqueia a execução do endpoint
        }

        // Registre a nova solicitação
        requests.offer(currentTime);
        logger.info("Request registered for IP: " + ip + ". Current count: " + requests.size()); // Log request count

        chain.doFilter(req, res); // Continua com a cadeia de filtros
    }

    @Override
    public void destroy() {
        // Cleanup se necessário
    }
}
