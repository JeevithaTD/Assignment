package com.task.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.task.customerservice.model.ExceptionResponse;

@ControllerAdvice
public class CustomerControllerExceptionHandler extends ResponseEntityExceptionHandler {
	
		
	/**
	 * This method to handle DataNotFoundException
	 * @param ex
	 * @return ResponseEntity
	 */
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleDataNotFoundException(Exception ex){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * This method to handle JsonMappingException and JsonParseException
	 * @param ex
	 * @return ResponseEntity
	 */
	
	@ExceptionHandler({JsonMappingException.class,JsonParseException.class})
	public ResponseEntity<ExceptionResponse> handleJsonMappingException(Exception ex){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method to handle CustomerServiceException
	 * @param ex
	 * @return ResponseEntity
	 */

	@ExceptionHandler(CustomerServiceException.class)
	public ResponseEntity<ExceptionResponse> handleCustomerServiceException(Exception ex){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	/**
	 * This method to handle all other Exception
	 * @param ex
	 * @return ResponseEntity
	 */
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> defaultExceptionHandler(Exception ex){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
