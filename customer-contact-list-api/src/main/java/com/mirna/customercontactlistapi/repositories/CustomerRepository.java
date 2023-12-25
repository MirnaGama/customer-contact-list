package com.mirna.customercontactlistapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirna.customercontactlistapi.domain.entities.Customer;

/**
 * 
 * @author Mirna Gama
 * @version 1.0
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
