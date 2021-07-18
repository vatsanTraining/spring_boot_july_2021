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
	
	@GetMapping(path = "/client/restaurants")
	public Flux<String> findRestaurants(){
		
		
		return client.get().uri("http://localhost:4040/api/v1/restaurants")
		                .retrieve().bodyToFlux(String.class);
	}
}
