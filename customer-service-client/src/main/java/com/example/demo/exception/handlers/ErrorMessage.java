package com.example.demo.exception.handlers;

public class ErrorMessage {

	private String responseBodyAsString;
	
	private  String string;

	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(String responseBodyAsString, String string) {
		super();
		this.responseBodyAsString = responseBodyAsString;
		this.string = string;
	}

	public String getResponseBodyAsString() {
		return responseBodyAsString;
	}

	public void setResponseBodyAsString(String responseBodyAsString) {
		this.responseBodyAsString = responseBodyAsString;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	
}
