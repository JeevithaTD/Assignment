package com.task.customerservice.service;

import java.util.List;

import com.task.customerservice.exception.CustomerServiceException;
import com.task.customerservice.exception.DataNotFoundException;
import com.task.customerservice.model.Customer;

public interface CustomerService {

	public Customer customerInfo(Customer customerInfo);
	
	public List<Customer> customerInfo(List<Customer> customerInfo) throws CustomerServiceException;
	
	public Customer getCustomerInfo(Long refId) throws DataNotFoundException;
}
