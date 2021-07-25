package com.example.demo.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.example.demo.services.StudentService;

@Configuration
public class StudentHandler {

	@Bean
	public RouterFunction<ServerResponse> getAllStudents(StudentService service) {

		return RouterFunctions.route().GET("/students",RequestPredicates.accept(MediaType.TEXT_PLAIN),
				service::findAll)
				.GET("/students/{id}",RequestPredicates.accept(MediaType.APPLICATION_JSON),service::findById)
				.POST("/students",RequestPredicates.accept(MediaType.APPLICATION_JSON),service::addStudent).build();
		
 
	}
}
