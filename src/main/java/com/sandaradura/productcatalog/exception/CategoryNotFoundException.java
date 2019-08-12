package com.sandaradura.productcatalog.exception;

public class CategoryNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 6711499314249345257L;

	public CategoryNotFoundException(String message){
		super(message);
	}

}
