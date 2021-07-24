package com.example.demo.entity;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "catalog_images")
public class Image {

	

	    @Id
	    private String id;
	    String name; 
	    LocalDate createdtime; 
	    @Lob
	    byte[] content; 
	    String contentType; 
	    long size; 
	    
	    
	
}
