package com.task.customerexternalservice.services.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.task.customerexternalservice.exception.CustomerExternalServiceFileNotFoundException;
import com.task.customerexternalservice.models.Customer;
import com.task.customerexternalservice.proxy.CustomerServiceProxy;
import com.task.customerexternalservice.services.CustomerExternalBusinessService;
import com.task.customerexternalservice.services.FileHandlerService;

@Service
public class CustomerExternalBusinessServiceImpl implements CustomerExternalBusinessService {

    @Autowired
    FileHandlerService fileHandlerService;

    @Autowired
    CustomerServiceProxy customerServiceProxy;
    
    /**
     * This method reads the file and post the customer Info to customer service
     */
    @Override
    public void processExternalFile(String fileLocation) throws JsonParseException, JsonMappingException, IOException, CustomerExternalServiceFileNotFoundException {

        List<Customer> customerDetails = fileHandlerService.getCustomerDetailsFromDisk(fileLocation);

        customerServiceProxy.sendDataToCustomerService(customerDetails);


    }
}
