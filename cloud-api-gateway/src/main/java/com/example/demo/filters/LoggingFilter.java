package com.example.demo.filters;

import java.util.logging.Logger;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Log4j2
public class LoggingFilter implements GlobalFilter {


	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		ServerHttpRequest request = exchange.getRequest();
		   

		
		        return chain.filter(exchange);	}

}
