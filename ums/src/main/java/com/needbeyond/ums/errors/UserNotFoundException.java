package com.needbeyond.ums.errors;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(long id){
		super("No user found with the id : "+id);
	}
}
