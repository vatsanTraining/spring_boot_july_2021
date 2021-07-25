package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	
	  @Autowired
	  RestTemplate template;
	  
	  
	  @GetMapping(path = "/client")
	  public String getInfo() {
		  
		  return this.template.getForObject("http://localhost:6060/info", String.class);
	  }
	  
	  
	  
}
