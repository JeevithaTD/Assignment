package com.task.customerexternalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.task.customerexternalservice.services.CustomerExternalBusinessService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class CustomerExternalServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CustomerExternalServiceApplication.class, args);
	}

	@Autowired
	CustomerExternalBusinessService customerExternalService;

	@Value("${customer.file.location}")
	String fileLocation;

	@Override
	public void run(String... args) throws Exception {

		log.info("CustomerExternalServiceApplication: run: Started Application load method");
		customerExternalService.processExternalFile(fileLocation);

	}
}
