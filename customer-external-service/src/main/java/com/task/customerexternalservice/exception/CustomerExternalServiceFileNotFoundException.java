package com.task.customerexternalservice.exception;

public class CustomerExternalServiceFileNotFoundException extends Exception {

	/**
	 * This service handles File not found exception specifically
	 */
	private static final long serialVersionUID = 7513167932221408195L;

	public CustomerExternalServiceFileNotFoundException(String message, Exception e) {
		super(message, e);
	}
}
