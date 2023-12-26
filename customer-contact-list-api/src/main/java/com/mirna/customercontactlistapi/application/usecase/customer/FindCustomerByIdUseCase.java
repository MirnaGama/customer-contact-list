package com.mirna.customercontactlistapi.application.usecase.customer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.exceptions.EntityNotPresentException;
import com.mirna.customercontactlistapi.repositories.CustomerRepository;

/**
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class FindCustomerByIdUseCase {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer execute(UUID id) throws EntityNotPresentException {
        return this.customerRepository.findById(id).orElseThrow(() -> new EntityNotPresentException("Cliente não existe"));
    }
}
