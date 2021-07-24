package com.example.demo.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class AuthorizeFilter implements GatewayFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
	
		boolean result =
				exchange.getRequest().getURI().
				        getRawPath().contains("a102");
				      
				   if(result) {
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
				        return exchange.getResponse().setComplete();
				        }
				      
				return chain.filter(exchange);

	}

}
