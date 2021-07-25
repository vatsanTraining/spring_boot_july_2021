package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ClientController {

	
	  @Autowired
	  RestTemplate template;

	
	  
	  @GetMapping(path = "/client")
	  @CircuitBreaker(name = "infoService", fallbackMethod = "getInfoFallback")
	  public String getInfo() {
		  
		  return this.template.getForObject("http://localhost:6060/info", String.class);
	  }
	  
	  
	  public String getInfoFallback(Exception e) {
		  
		  //	  return this.template.getForObject("http://localhost:6066/info", String.class);
		  
		  return "This is cached  message";

	  }
	  
}
