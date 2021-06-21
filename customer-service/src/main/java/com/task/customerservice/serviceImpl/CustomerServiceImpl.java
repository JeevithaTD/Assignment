package com.task.customerservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.customerservice.exception.CustomerServiceException;
import com.task.customerservice.exception.DataNotFoundException;
import com.task.customerservice.model.Customer;
import com.task.customerservice.repository.CustomerRepository;
import com.task.customerservice.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	public CustomerRepository customerRepository;
	
	/**
	 * This method save/update customer info to DB
	 * @param Customer
	 * @return Customer
	 */
	
	public Customer customerInfo(Customer customerInfo)  {

		return customerRepository.save(customerInfo);

	}
	
	/**
	 * This method save/update list of Customer info to DB
	 * @param List<Customer>
	 * @return List<Customer>
	 */

	public List<Customer> customerInfo(List<Customer> customerInfo) throws CustomerServiceException {

		return customerRepository.saveAll(customerInfo);

	}
	
	/**
	 * This method will connect to DB and get customer info based on refId
	 * @param refId
	 * @return Customer
	 * @exception DataNotFoundException
	 */

	public Customer getCustomerInfo(Long refId) throws DataNotFoundException {
		
		log.info(" CustomerServiceImpl :  getCustomerInfo :refId "+ refId);
		Customer customerInfo = customerRepository.findById(refId).orElse(null);
		
		if(null == customerInfo) {
			System.out.println("test");
			throw new DataNotFoundException("CustomerId not found");
		}
		log.info(" CustomerServiceImpl :  getCustomerInfo :customerInfo "+ customerInfo.toString());
		return customerInfo;
	}

}
