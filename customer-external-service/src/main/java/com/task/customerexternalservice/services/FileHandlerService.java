package com.task.customerexternalservice.services;


import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.task.customerexternalservice.exception.CustomerExternalServiceFileNotFoundException;
import com.task.customerexternalservice.models.Customer;

public interface FileHandlerService {

    List<Customer> getCustomerDetailsFromDisk(String uri) throws JsonParseException, JsonMappingException, IOException, CustomerExternalServiceFileNotFoundException;
}
