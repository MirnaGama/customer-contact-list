package com.mirna.customercontactlistapi.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mirna.customercontactlistapi.domain.dto.CustomerDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.services.CustomerService;

import jakarta.validation.Valid;

/**
 * A Spring REST controller for managing customers.
 *
 * @author Mirna Gama
 * @version 1.0
 */
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	/*
	 * Post method to create a new Customer object based on the provided DTO.
	 *
	 * @param customerDTO The data transfer object containing data for Customer
	 * entity.
	 * 
	 * @return A response entity containing the saved customer if successful, or
	 * a 400-level error if there is a validation error
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		
		Customer customer = customerService.addCustomer(customerDTO);
		
		return ResponseEntity.ok(customer);
	}
}
