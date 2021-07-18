package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping(path = "/api/v1")
public class CustomerController {

	
    @Value("${server.port}")
     private String portNumber;
	
	
	@GetMapping(path = "/customers")
	public String getCustomer() {
		
		return "Ramesh,Suresh,Magesh" +":"+ this.portNumber;
	}
}
