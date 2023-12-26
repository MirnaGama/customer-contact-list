package com.mirna.customercontactlistapi.domain.services;

import org.springframework.stereotype.Service;

import com.mirna.customercontactlistapi.domain.dto.TelephoneDTO;
import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.exceptions.EntityNotPresentException;

/**
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Service
public interface TelephoneService {

	 public Telephone addTelephone(TelephoneDTO telephoneDTO) throws EntityNotPresentException;

	 public Telephone addTelephone(Telephone telephone);
	 
}
