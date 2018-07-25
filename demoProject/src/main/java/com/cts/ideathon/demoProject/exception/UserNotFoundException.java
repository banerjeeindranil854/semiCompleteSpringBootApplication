package com.cts.ideathon.demoProject.exception;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	  public UserNotFoundException(String exception) {
	    super(exception);
	  }
	}
