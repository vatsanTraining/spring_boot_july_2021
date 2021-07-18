package com.example.demo.custom.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Details;

@WebEndpoint(id = "custom")
@Component
public class MyCustomEndpoint {

	private StringBuffer buffer = new StringBuffer("Custom Endpoint");
	
	@ReadOperation
	public String getInfo() {
		
		return buffer.toString();
		
	}
	
	// Sample Data for Post from postman {"addInfo":"[{'id':101}]"}

	
	@WriteOperation
	public String addInfo(String addInfo) {
		
		return buffer.append(addInfo).toString();
		
	}
	
}
