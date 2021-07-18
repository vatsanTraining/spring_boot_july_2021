package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tour;
import com.example.demo.service.TourService;

@RestController
public class TourController {

	
	
	@Autowired
	private TourService service;
	
	
	
	@GetMapping(path = "/api/v1/tours")
	public List<Tour> getTours() {
		
		return this.service.findAll();
	}
	
	
	@PostMapping(path = "/api/v1/tours")
	public Tour addTour(@RequestBody Tour tour) {
		
		return this.service.addTour(tour);
	}
	
}
