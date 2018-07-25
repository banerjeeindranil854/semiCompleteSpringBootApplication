package com.cts.ideathon.demoProject.exception;

@SuppressWarnings("serial")
public class RegisterUserNotFoundException extends RuntimeException{
	public RegisterUserNotFoundException(String exception) {
	    super(exception);
	  }
}
