package com.mirna.customercontactlistapi.application.usecase.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.repositories.CustomerRepository;

/**
 * This class is used to execute the deleteAll method from customer repository
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class DeleteAllCustomersUseCase {

	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * Executes the deleteAll method from customer repository
	 *
	 */
	public void execute() {
        this.customerRepository.deleteAll();
    }
}
