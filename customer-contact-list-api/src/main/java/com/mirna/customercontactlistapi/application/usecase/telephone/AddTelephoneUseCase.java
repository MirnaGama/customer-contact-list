package com.mirna.customercontactlistapi.application.usecase.telephone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.repositories.TelephoneRepository;

/**
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class AddTelephoneUseCase {

	@Autowired
	private TelephoneRepository telephoneRepository;
	
	public Telephone execute(Telephone telephone) {
        return this.telephoneRepository.save(telephone);
    }
}
