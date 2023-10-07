package com.example.jasperreport.util;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -644783035232411111L;
	
	@SuppressWarnings("unused")
	private String message;

	public ProductNotFoundException(String message) {
		super(message);
		this.message = message;
	}
}
