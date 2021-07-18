package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "review_july")
public class Review {

	@Id
	private int id;
	private String reviewer;
	private double rating;
}
