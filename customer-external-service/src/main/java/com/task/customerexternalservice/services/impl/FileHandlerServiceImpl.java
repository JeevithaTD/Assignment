package com.task.customerexternalservice.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.customerexternalservice.exception.CustomerExternalServiceFileNotFoundException;
import com.task.customerexternalservice.models.Customer;
import com.task.customerexternalservice.services.FileHandlerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileHandlerServiceImpl implements FileHandlerService {

	
	/**
	 * This method reads data from file with specified location and sends the object
	 */

    @Override
    public List<Customer> getCustomerDetailsFromDisk(String uri) throws JsonParseException, JsonMappingException, IOException, CustomerExternalServiceFileNotFoundException {
       
    	List<Customer> customerDetails = new ArrayList<>();
    	
        ObjectMapper objectMapper = new ObjectMapper();
        log.info("FileHandlerServiceImpl : getCustomerDetailsFromDisk: Customer Details : uri: "+uri);
        
        try {

         customerDetails = objectMapper.readValue(
                new File(uri),
                new TypeReference<List<Customer>>(){});
        
        }catch(FileNotFoundException e) {
        	
        	log.error("Provided URI: {} not found ", uri, e);
        	throw new CustomerExternalServiceFileNotFoundException("File not found in specified location ", e);
        }

        log.info("FileHandlerServiceImpl : getCustomerDetailsFromDisk: Customer Details" + customerDetails.toString());

        return customerDetails;
    }


}
