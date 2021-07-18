package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PaymentClientController {

	@Autowired
	private WebClient client;
		
	@GetMapping(path = "/client/payments")
	public Flux<String> getCustomers(){
		
		   return  client.get()
				     .uri("http://PAYMENT-SERVICE/api/v1/payments")
				      .headers(headers -> headers.setBasicAuth("india","india"))
				        .retrieve()
				        .onStatus(HttpStatus::is5xxServerError, clientResponse ->
				        Mono.error(new RuntimeException()))
				        .bodyToFlux(String.class);
	}
}
