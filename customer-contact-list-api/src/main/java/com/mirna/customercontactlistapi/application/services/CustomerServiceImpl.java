package com.mirna.customercontactlistapi.application.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirna.customercontactlistapi.application.usecase.customer.AddCustomerUseCase;
import com.mirna.customercontactlistapi.application.usecase.customer.FindAllCustomersUseCase;
import com.mirna.customercontactlistapi.application.usecase.customer.FindCustomerByIdUseCase;
import com.mirna.customercontactlistapi.domain.dto.CustomerDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.mappers.CustomerMapper;
import com.mirna.customercontactlistapi.domain.services.CustomerService;
import com.mirna.customercontactlistapi.exceptions.EntityNotPresentException;

/**
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
	private CustomerMapper customerMapper;
	
	@Override
	public Customer addCustomer(CustomerDTO customerDTO) {
		Customer customer = this.customerMapper.toCustomerEntity(customerDTO);	
		return addCustomer.execute(customer);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return addCustomer.execute(customer);
	}
	
	@Override
	public Customer findCustomerById(UUID id) throws EntityNotPresentException {
		return findCustomerById.execute(id);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return findAllCustomers.execute();
	}

}
