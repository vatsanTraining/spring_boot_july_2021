package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping(path = "/api/v1")
public class CustomerController {

	
    @Value("${server.port}")
     private String portNumber;
	
    @Value("${custom.message}")
    private String message;
	
	
	@GetMapping(path = "/customers")
	public String getCustomer() {
		
		 
		return "Ramesh,Suresh,Magesh" +":"+ this.message;
	}
}
