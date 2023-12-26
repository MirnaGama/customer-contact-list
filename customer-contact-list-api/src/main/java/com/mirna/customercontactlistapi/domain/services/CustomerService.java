package com.mirna.customercontactlistapi.domain.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirna.customercontactlistapi.domain.dto.CustomerDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.exceptions.EntityNotPresentException;

/**
 * Customer service interface for managing customer information.
*
 * @see Customer
 * @author Mirna Gama
 * @version 1.0
*/
@Service
public interface CustomerService {

	/**
	* Adds a new customer to the repository.
	* 
	* @param customerDTO A data transfer object representing a customer to add.
	* @return The saved customer if successful,  or null if there is an error.
	*/
    public Customer addCustomer(CustomerDTO customer);

	/**
	 * Adds a new customer to the repository.
	 * 
	 * @param customer The customer entity to be added.
	 * @return The saved customer if successful, or null if there is an error.
	 */
    public Customer addCustomer(Customer customer);

	/**
	 * Searches for a customer by id.
	 * 
	 * @param id The unique identifier of the customer to find.
	 * @throws EntityNotPresentException If there is an error in finding the customer.
	 * @return The found customer.
	 */
    public Customer findCustomerById(UUID id) throws EntityNotPresentException;
    
	/**
	 * Retrieves a list of all customers.
	 * 
	 * @return  A list containing all objects of type Customer in the repository
	 */
    public List<Customer> findAllCustomers();

}