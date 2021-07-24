package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.filters.AuthorizeFilter;

@Configuration
public class RouteConfig {

	
	@Bean
	public RouteLocator gateWayRoutes(RouteLocatorBuilder builder,AuthorizeFilter authFilter) {
		
		 return builder.routes()
		           .route(p -> p.path("/api/v1/customers/**")
		                    .uri("lb://AGENT-SERVICE"))
		            .route(p-> p.path("/file/image/**")
		            		.filters(f -> f.filter(authFilter,0)).uri("http://localhost:4042"))
		                .build();		
	}
}
