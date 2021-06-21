package com.task.customerservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "CUSTOMER_DETAIL")
public class Customer {
		@Id
		@GeneratedValue
		private Long customerRefId;
		private String customerName;
		private String addressLine1;
		private String addressLine2;
		private String town;
		private String county;
		private String country;
		private String postcode;
		
		
}
