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
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		
		Customer customer = customerService.addCustomer(customerDTO);
		
		return ResponseEntity.ok(customer);
	}
}
