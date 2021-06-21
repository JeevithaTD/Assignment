package com.task.customerexternalservice.services;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.task.customerexternalservice.exception.CustomerExternalServiceFileNotFoundException;

public interface CustomerExternalBusinessService {

    void processExternalFile(String fileLocation) throws JsonParseException, JsonMappingException, IOException, CustomerExternalServiceFileNotFoundException;

}
