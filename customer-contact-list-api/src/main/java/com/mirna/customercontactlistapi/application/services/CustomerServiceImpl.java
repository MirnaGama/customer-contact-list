package com.mirna.customercontactlistapi.application.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirna.customercontactlistapi.application.usecase.customer.AddCustomerUseCase;
import com.mirna.customercontactlistapi.application.usecase.customer.DeleteAllCustomersUseCase;
import com.mirna.customercontactlistapi.application.usecase.customer.FindAllCustomersUseCase;
import com.mirna.customercontactlistapi.application.usecase.customer.FindCustomerByIdUseCase;
import com.mirna.customercontactlistapi.domain.dto.CustomerDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.exceptions.EntityNotPresentException;
import com.mirna.customercontactlistapi.domain.mappers.CustomerMapper;
import com.mirna.customercontactlistapi.domain.services.CustomerService;

/**
 * This class is an implementation of the CustomerService interface.
 *
 * This class provides methods to perform operations on customers
 *
 * @author Mirna Gama
 * @version 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private AddCustomerUseCase addCustomer;

	@Autowired
	private FindCustomerByIdUseCase findCustomerById;

	@Autowired
	private FindAllCustomersUseCase findAllCustomers;
	
	@Autowired
	private DeleteAllCustomersUseCase deleteAllCustomers;

	@Autowired
	private CustomerMapper customerMapper;

	/**
	 * Adds a new customer to the database.
	 *
	 * @param customerDTO A data transfer object containing the data for Customer
	 *                    entity.
	 * @return The saved customer if successful, or null if there is an error.
	 */
	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		Customer customer = this.customerMapper.toCustomerEntity(customerDTO);
		return addCustomer.execute(customer);
	}

	/**
	 * Adds a new customer to the database.
	 *
	 * @param customer a Customer entity representing the new customer record.
	 * @return The saved customer if successful, or null if there is an error.
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		return addCustomer.execute(customer);
	}

	/**
	 * Finds a customer from the database by ID.
	 *
	 * @param id The ID of the customer to be found.
	 * @return the customer if it exists in the database, or throws an exception if
	 *         it is not found.
	 * @throws com.mirna.customercontactlistapi.domain.exceptions.EntityNotPresentException if the customer does not exist in the
	 *                                 database.
	 */
	@Override
	public Customer findCustomerById(UUID id) throws EntityNotPresentException {
		return findCustomerById.execute(id);
	}

	/**
	 * Finds all customers from the database.
	 *
	 * @return A list containing all objects of type Customer in the database
	 */
	@Override
	public List<Customer> findAllCustomers() {
		return findAllCustomers.execute();
	}

	/**
	 * Deletes all customers from the database.
	 *
	 */
	@Override
	public void deleteAllCustomers() {
		deleteAllCustomers.execute();
	}

}
