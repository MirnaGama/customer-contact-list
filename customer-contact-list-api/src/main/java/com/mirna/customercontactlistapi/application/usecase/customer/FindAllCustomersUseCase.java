package com.mirna.customercontactlistapi.application.usecase.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.repositories.CustomerRepository;

/**
 * This class is used to execute the findAll method from customer repository
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class FindAllCustomersUseCase {

	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * Executes the findAll method from customer repository
	 *
	 * @return  A list containing all objects of type Customer in the repository
	 */
	public List<Customer> execute() {
        return this.customerRepository.findAll();
    }
}
