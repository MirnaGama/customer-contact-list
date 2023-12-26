package com.mirna.customercontactlistapi.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirna.customercontactlistapi.domain.entities.Customer;

/**
 * Repository interface for retrieving and manipulating all Customer objects using their unique UUID identifier.
*
 * @author Mirna Gama
* @version 1.0
*/
public interface CustomerRepository extends JpaRepository<Customer, UUID>{

}
