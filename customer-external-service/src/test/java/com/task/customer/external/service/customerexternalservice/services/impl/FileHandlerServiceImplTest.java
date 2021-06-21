package com.task.customer.external.service.customerexternalservice.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.task.customerexternalservice.exception.CustomerExternalServiceFileNotFoundException;
import com.task.customerexternalservice.models.Customer;
import com.task.customerexternalservice.services.FileHandlerService;
import com.task.customerexternalservice.services.impl.FileHandlerServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration
@Slf4j
public class FileHandlerServiceImplTest {
	
	@Autowired
	public	FileHandlerServiceImpl fileHandlerServiceImpl;
	
	@Configuration
	static class Config{
		
	@Bean
	public	FileHandlerService getFileHandlerServiceImpl() {
			return new FileHandlerServiceImpl();
		}
	}
	
	@Test
	public void getCustomerDetailsFromDisk_test() throws JsonParseException, JsonMappingException, IOException, CustomerExternalServiceFileNotFoundException {
		
		File file = ResourceUtils.getFile(
			      "classpath:customer.json");
		log.debug("uri"+file.getAbsolutePath().toString());
		List<Customer> customerInfo = fileHandlerServiceImpl.getCustomerDetailsFromDisk(file.getAbsolutePath().toString());
		
		assertEquals(1l, customerInfo.get(0).getCustomerRefId());
	}
	
	@Test(expected = CustomerExternalServiceFileNotFoundException.class)
	public void getCustomerDetailsFromDiskException_test() throws JsonParseException, JsonMappingException, IOException, CustomerExternalServiceFileNotFoundException {
		
		fileHandlerServiceImpl.getCustomerDetailsFromDisk("test.json");
		
	}
}
