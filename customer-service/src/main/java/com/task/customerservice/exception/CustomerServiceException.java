package com.task.customerservice.exception;

public class CustomerServiceException extends Exception {

	/**
	 * This Exception will be used to throw any Applciation specific Exception
	 */
	private static final long serialVersionUID = 3712071412228252975L;

	public CustomerServiceException(String message) {
		super(message);
	}
	
	public CustomerServiceException(String message, Exception e) {
		super(message, e);
	}
	
	
}
