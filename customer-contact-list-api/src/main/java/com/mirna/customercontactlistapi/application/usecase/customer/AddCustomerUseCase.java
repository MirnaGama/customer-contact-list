package com.mirna.customercontactlistapi.application.usecase.customer;

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
public class AddCustomerUseCase {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer execute(Customer customer) {
        return this.customerRepository.save(customer);
    }
}
