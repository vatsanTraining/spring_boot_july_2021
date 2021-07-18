package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.PaymentService;

@RestController
@RequestMapping(path = "/api/v1")
public class PaymentController {

	
	@Autowired
	private PaymentService service;
	
	@PermitAll
	@GetMapping(value = "/payments/{id}")
	public String getById(@PathVariable("id") int id){
		
		return service.getById(id);
	}

	@GetMapping(value = "/payments")
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public String getAll(){
		
		return service.getList().toString();
	}
	
}

