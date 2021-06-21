package com.task.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.task.customerservice.exception.CustomerServiceException;
import com.task.customerservice.exception.DataNotFoundException;
import com.task.customerservice.model.Customer;
import com.task.customerservice.serviceImpl.CustomerServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/customers")
@ResponseBody
@Api(value="Customer Service API")
public class CustomerController {

	@Autowired
	public CustomerServiceImpl service;
	
	/**
	 * This method will accept Post request body and saves customerInfo into DB
	 * @param customerInfo
	 * @return
	 * @throws CustomerServiceException
	 */
	
	@ApiOperation(value="To save the customer information to the database")
	@PostMapping(consumes="application/json")
	public List<Customer> postCustomerInfo(@RequestBody List<Customer> customerInfo) throws CustomerServiceException {
		service.customerInfo(customerInfo);		
		return customerInfo;
		
	}
	
	/**
	 * This method will return customerInfo based on refId
	 * @param refId
	 * @return
	 * @throws DataNotFoundException
	 */
	
	@ApiOperation(value="To retrieve the customer information by giving the refId")
	@GetMapping(path="/{refId}")
	public Customer getCustomerInfo(@PathVariable Long refId) throws DataNotFoundException {
		
		System.out.println("inside: getCustomerInfo : "+ refId);
		
		Customer customerInfo = service.getCustomerInfo(refId);
		
		
		return customerInfo;
		
	}
}
