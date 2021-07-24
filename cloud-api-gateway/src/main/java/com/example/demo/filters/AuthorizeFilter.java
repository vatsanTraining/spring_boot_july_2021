package com.example.demo.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.logging.*;
@Component
public class AuthorizeFilter implements GatewayFilter {

	                Logger log = Logger.getGlobal();
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
	
		log.info("Gateway Filter Called");
		boolean result =
				exchange.getRequest().getURI().
				        getRawPath().contains("a102");
				      
				   if(result) {
				exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
				log.info("Prevented the request from completing");
				        return exchange.getResponse().setComplete();
				        }
				      
				return chain.filter(exchange);

	}

}
