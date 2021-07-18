package com.example.demo.services;

import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class PaymentService {

	HashMap<Integer, String> list;
	
	public PaymentService() {
		super();
		
		list = new HashMap<>();
		list.put(1, "Ramesh");
		list.put(2, "Suresh");
	}

	
	public String getById(int id) {
		
		return list.get(id);
	}


	public Map<Integer, String> getList() {
		return list;
	}
	
	

	
}
