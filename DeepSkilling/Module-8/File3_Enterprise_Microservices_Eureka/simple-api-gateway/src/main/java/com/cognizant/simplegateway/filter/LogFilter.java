package com.cognizant.simplegateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Global filter that logs every request routed through the gateway
 * (step 21 in the walkthrough).
 */
@Component
public class LogFilter implements GlobalFilter {

    private static final Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Incoming request via gateway: {}", exchange.getRequest().getURI());
        return chain.filter(exchange);
    }
}
