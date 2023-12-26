package com.mirna.customercontactlistapi.application.usecase.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.repositories.CustomerRepository;

/**
 * This class is used to execute the save method from customer repository
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class AddCustomerUseCase {

	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * Executes the save method from Customer repository
	 * 
	 * @param customer The customer to be saved in the repository
	 * @return The saved customer if successful, or null if there is an error
	 *
	 */
	public Customer execute(Customer customer) {
        return this.customerRepository.save(customer);
    }
}
