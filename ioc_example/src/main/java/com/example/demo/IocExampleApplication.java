package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Customer;

@SpringBootApplication
public class IocExampleApplication {

	public static void main(String[] args) {
		
		// Obtaining the Reference of the Application Context which is an IoC Container
		
	ConfigurableApplicationContext ctx =	SpringApplication.run(IocExampleApplication.class, args);
	
	      
	   Customer cust = ctx.getBean(Customer.class);
	    
	    System.out.println(cust);
	    
	    
	System.out.println(ctx.getClass().getName());
	
	    
	
	}

}
