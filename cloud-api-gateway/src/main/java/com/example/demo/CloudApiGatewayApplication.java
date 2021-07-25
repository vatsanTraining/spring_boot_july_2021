package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.http.HttpTracing;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApiGatewayApplication.class, args);
	}
	

}
