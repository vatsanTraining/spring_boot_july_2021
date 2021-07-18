package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component

public class Details {

	
	private int id;
	private String detail;
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Details [id=" + id + ", detail=" + detail + "]";
	}
	
	
}
