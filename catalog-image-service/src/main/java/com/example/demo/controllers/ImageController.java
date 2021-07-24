package com.example.demo.controllers;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Image;
import com.example.demo.repos.ImageRepository;

@RestController
public class ImageController {

	ImageRepository repo;

	public ImageController(ImageRepository repo) {
		super();
		this.repo = repo;
	}
	
	@PostMapping(path = "/file/uploadImage")
	public ResponseEntity<String> uploadImage(@RequestParam(value = "id") String id,
			       @RequestParam(value = "image") MultipartFile file){
		
        ResponseEntity<String> resp=null;

	    if(file.isEmpty()) {
	            return  ResponseEntity.ok().body("please select a picture");
	    } else {
	  	    String fileName = file.getOriginalFilename();
	    try {
	        Image uploadFile = new Image();
	        uploadFile.setName(fileName);
	        uploadFile.setCreatedtime(LocalDate.now());
	        uploadFile.setContent(file.getBytes());
	        uploadFile.setContentType(file.getContentType());
	        uploadFile.setSize(file.getSize());
	        uploadFile.setId(id);

	        Image savedFile = repo.save(uploadFile);
	        String url = "http://localhost:4042/file/image/"+ savedFile.getId();
	        resp=ResponseEntity.ok().body("image uploaded successfully"+url);
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	        resp =  ResponseEntity.badRequest().body("image upload failed");
	    }
	    }
	    return resp;

	}
	
	@GetMapping(value = "/file/image/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	public byte[] fetchImage(@PathVariable String id){
	    byte[] data = null;
	    Image file = repo.findById(id).get();
	        if(file != null){
	        data = file.getContent();
	    }
	    return data;
	}
}

