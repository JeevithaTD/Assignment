package com.task.customerservice.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.task.customerservice.exception.CustomerServiceException;
import com.task.customerservice.model.Customer;
import com.task.customerservice.repository.CustomerRepository;
import com.task.customerservice.service.CustomerService;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class CustomerServiceImplTest {

	
	@MockBean
	public CustomerRepository customerRepository;

	@Autowired
	public CustomerServiceImpl service;
	
	
	
	@Configuration
	static class ConfigClass{
		
		@Bean
		public CustomerService getCustomerService() {
			return new CustomerServiceImpl();
		}
	}
	

	@Test
	public void customerInfoTest()  {
		Customer customerInfo = new Customer(1L, "Hari", "Sycamore court", "Brookroad", "Redhill", "Surrey", "UK",
				"RH1 6BQ");
		when(customerRepository.save(customerInfo)).thenReturn(customerInfo);
		assertEquals(customerInfo, service.customerInfo(customerInfo));

	}
	
	@Test
	public void CustomerInfoListTest() throws CustomerServiceException {
		List<Customer> customer=getCustomerdata();
		when(customerRepository.saveAll(customer)).thenReturn(customer);
		assertEquals(customer, service.customerInfo(customer));
	}

	@Test
	public void getCustomerInfoTest() {
		Long refId = 1L;
		when(customerRepository.findById(refId)).thenReturn(Optional
				.of(new Customer(1L, "Hari", "Sycamore court", "Brookroad", "Redhill", "Surrey", "UK", "RH1 6BQ")));

	}
	
	private List<Customer> getCustomerdata() {
		List<Customer> customer = new ArrayList<>();
		customer.add(new  Customer(1L, "Hari", "Sycamore court", "Brookroad", "Redhill", "Surrey", "UK",
				"RH1 6BQ"));
		customer.add(new  Customer(2L, "Jeevitha", "Sycamore court", "Brookroad", "Redhill", "Surrey", "UK",
				"RH1 6BQ"));
		
		return customer;
		
	}
	
	
}
