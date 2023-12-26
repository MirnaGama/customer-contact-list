package com.mirna.customercontactlistapi.application.usecase.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.repositories.CustomerRepository;

/**
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class FindAllCustomersUseCase {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> execute() {
        return this.customerRepository.findAll();
    }
}
