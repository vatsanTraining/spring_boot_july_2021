package com.example.demo.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Image;

public interface ImageRepository extends JpaRepository<Image, String> {

	
	
}
