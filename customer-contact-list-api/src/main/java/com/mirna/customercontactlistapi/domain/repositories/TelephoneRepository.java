package com.mirna.customercontactlistapi.domain.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirna.customercontactlistapi.domain.entities.Telephone;

/**
 * Repository interface for retrieving and manipulating all Telephone objects using their unique UUID identifier.
*
 * @author Mirna Gama
* @version 1.0
*/
public interface TelephoneRepository extends JpaRepository<Telephone, UUID> {
	
}
