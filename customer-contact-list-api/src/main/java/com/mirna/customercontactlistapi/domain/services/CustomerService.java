package com.mirna.customercontactlistapi.domain.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirna.customercontactlistapi.domain.dto.CustomerDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;

@Service
public interface CustomerService {

    public Customer addCustomer(CustomerDTO customer);

    public Customer addCustomer(Customer customerDTO);

    public Customer findCustomerById(UUID id) throws Exception;
    
    public List<Customer> findAllCustomers();

}