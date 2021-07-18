package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.reactive.ReactiveLoadBalancer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustomerServiceClientApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx	=SpringApplication.run(CustomerServiceClientApplication.class, args);
	
	}
	
	
	@Bean
	@LoadBalanced
	public WebClient.Builder builder(){
		
		return WebClient.builder();
	}
	@Bean
	public WebClient client(WebClient.Builder builderRef) {
		
		return builderRef.build();
	}

}
