package com.task.customerservice.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * This exception will be used throw no data found Scenarios
	 */
	private static final long serialVersionUID = -1823418537637354673L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
