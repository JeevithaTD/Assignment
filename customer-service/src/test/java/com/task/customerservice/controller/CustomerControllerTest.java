package com.task.customerservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.customerservice.exception.DataNotFoundException;
import com.task.customerservice.model.Customer;
import com.task.customerservice.serviceImpl.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest
public class CustomerControllerTest {

	@MockBean
	public CustomerServiceImpl customerServiceImpl;

	@Autowired
	private MockMvc mockMvc;

	ObjectMapper om = new ObjectMapper();

	@Test
	public void postCustomerInfoTest() throws Exception {

		String jsonRequest = om.writeValueAsString(getCustomerdata());
		MvcResult result = mockMvc
				.perform(post("/customers").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContext = result.getResponse().getContentAsString();
		System.out.println(resultContext);

		assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
	}

	@Test
	public void getCustomerInfoTest_ForDefaultMockBeanTest() throws Exception {
		
		 mockMvc
				.perform(MockMvcRequestBuilders.get("/customers/100"))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}
	
	@Test
	public void getCustomerInfoTest_ForHappyPath() throws Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		when(customerServiceImpl.getCustomerInfo(1l)).thenReturn(getCustomerobject());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/customers/1")).
				andExpect(MockMvcResultMatchers.status().is(200)).
				andExpect(MockMvcResultMatchers.content()
						.json(objectMapper.writeValueAsString(getCustomerobject())));

	}
	
	@Test
	public void getCustomerInfoTest_ForException() throws Exception {

		
		when(customerServiceImpl.getCustomerInfo(1l)).thenThrow(new DataNotFoundException("No Data Found"));
		
		mockMvc
				.perform(MockMvcRequestBuilders.get("/customers/1")).
				andExpect(MockMvcResultMatchers.status().is(404));		

	}


	private List<Customer> getCustomerdata() {
		List<Customer> customer = new ArrayList<>();
		customer.add(new Customer(1L, "Hari", "Sycamore court", "Brookroad", "Redhill", "Surrey", "UK", "RH1 6BQ"));
		customer.add(new Customer(2L, "Jeevitha", "Sycamore court", "Brookroad", "Redhill", "Surrey", "UK", "RH1 6BQ"));

		return customer;

	}
	
	private Customer getCustomerobject() {
		return new Customer(1L, "Hari", "Sycamore court", "Brookroad", "Redhill", "Surrey", "UK", "RH1 6BQ");
		
	}

}
