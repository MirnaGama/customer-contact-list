package com.mirna.customercontactlistapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mirna.customercontactlistapi.domain.entities.Telephone;

/**
 * 
 * @author Mirna Gama
 * @version 1.0
 */
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
	
}
