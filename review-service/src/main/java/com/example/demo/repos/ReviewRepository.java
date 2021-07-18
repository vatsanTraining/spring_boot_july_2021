package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entity.Review;
import java.util.List;

@RepositoryRestResource
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	
	List<Review> findByRating(double value);
	
	
}
