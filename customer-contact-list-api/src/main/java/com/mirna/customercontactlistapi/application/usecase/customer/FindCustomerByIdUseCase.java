package com.mirna.customercontactlistapi.application.usecase.customer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.exceptions.EntityNotPresentException;
import com.mirna.customercontactlistapi.repositories.CustomerRepository;

/**
 * This class is used to execute the findById method from customer repository
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class FindCustomerByIdUseCase {

	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * Executes the findById method from customer repository
	 * @param id The customer's unique identifier
	 * @return The Customer object if successful, or throw an exception if there is no entity present
	 * @throws EntityNotPresentException if the customer does not exist
	 */
	public Customer execute(UUID id) throws EntityNotPresentException {
        return this.customerRepository.findById(id).orElseThrow(() -> new EntityNotPresentException("Cliente não existe"));
    }
}
