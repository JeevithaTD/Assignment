package com.task.customerexternalservice.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.task.customerexternalservice.models.Customer;

@FeignClient(name = "customer-service", url = "http://localhost:8080")
public interface CustomerServiceProxy {
	
	/**
	 * This method invokes post of /customer Api
	 * @param customerDetails
	 */

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    void sendDataToCustomerService(@RequestBody List<Customer> customerDetails);

   }
