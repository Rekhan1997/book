package com.cruds.db;

public class BMSException extends Exception{
	
	private String details;

	public BMSException(String details) {
		super();
		this.details = details;
	}

	public String getDetails() {
		return details;
	}
}
