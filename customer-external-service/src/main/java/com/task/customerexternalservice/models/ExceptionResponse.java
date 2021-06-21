package com.task.customerexternalservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionResponse {

	private String message;	
	private int httpStatus;
}
