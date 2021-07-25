package com.example.demo.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.*;
import java.util.function.Predicate;

@Service
public class StudentService {


	List<Student> list;
	
	
	
	
	public StudentService() {
		super();
        list = new ArrayList<>();
        list.add(new Student(101, "Ramesh", 80));
        list.add(new Student(201, "suresh", 90));
	}




	public Mono<ServerResponse> findAll(ServerRequest req) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(list));
	
	}

	public Mono<ServerResponse> findById(ServerRequest req) {
		
		int id = Integer.parseInt(req.pathVariable("id"));
		Predicate<Student> predicate = s -> s.getId() == id;
		
		Student found = list.stream().filter(predicate).findFirst().get();
		
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromValue(found));

	}
	
	public Mono<ServerResponse> addStudent(ServerRequest req) {
		
		
		   Mono<Student> studentMono =req.bodyToMono(Student.class);
		   
		   
	        return studentMono.flatMap(student ->
	                ServerResponse.status(HttpStatus.OK)
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .body(addToList(student), Student.class));

	        
	}
	
	private Mono<Student> addToList(Student student){
		
		this.list.add(student);
		return Mono.just(student);
	}
}
