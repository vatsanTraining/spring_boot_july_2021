package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;




@RestController
public class ClientController {

	@Autowired
	private WebClient client;
		
	@GetMapping(path = "/client/customers")
	public Flux<String> getCustomers(){
		
		   return  client.get()
				     .uri("http://AGENT-SERVICE/api/v1/customers",101)
				      .retrieve()
				        .bodyToFlux(String.class);
	}
}
