package com.app.spring.enums;

public enum MessageConstants {

	SOMETHING_WENT_WRONG(0, "Something Went Wrong"),
	NO_ACCESS_TOKEN(1, "No Access Token");
	
	public int id;
	
	public String message;
	
	MessageConstants(int id, String message) {
		this.id = id;
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
	
	public int getId(){
		return id;
	}
	
}
