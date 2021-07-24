package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

	
	@Bean
	public RouteLocator gateWayRoutes(RouteLocatorBuilder builder) {
		
		 return builder.routes()
		           .route(p -> p.path("/api/v1/customers/**")
		                    .uri("lb://AGENT-SERVICE"))
		            .route(p-> p.path("/file/image/**").uri("http://localhost:4042"))
		                .build();		
	}
}
