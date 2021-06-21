package com.task.customerexternalservice.exception;

public class CustomerExternalServiceException extends Exception {

	/**
	 * This method handles application specific exception
	 * 
	 */
	private static final long serialVersionUID = -8666929941504072805L;

	public CustomerExternalServiceException(String message) {
		super(message);
	}
}
