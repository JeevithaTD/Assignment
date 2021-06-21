package com.task.customerexternalservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	
	private Long customerRefId;
	private String customerName;
	private String addressLine1;
	private String addressLine2;
	private String town;
	private String county;
	private String country;
	private String postcode;

}
