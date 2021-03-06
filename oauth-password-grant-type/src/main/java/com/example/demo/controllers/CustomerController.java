package com.example.demo.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Customer;

@RestController
@CrossOrigin(origins = "*")
public class CustomerController {

	
	
	@Autowired
	private Customer customer;
	
	
	@GetMapping(path = "/api/v1/customers")
	public Customer getCustomer(Principal principal) {
		
		System.out.println("==========="+principal.getName());
		
		return this.customer;
	}
	
	

}
