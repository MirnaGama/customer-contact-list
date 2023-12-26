package com.mirna.customercontactlistapi.application.usecase.telephone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.repositories.TelephoneRepository;

/**
 * This class is used to execute the save method from telephone repository
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class AddTelephoneUseCase {

	@Autowired
	private TelephoneRepository telephoneRepository;
	
	/**
	 * Executes the save method from Telephone repository
	 * 
	 * @param telephone The telephone to be saved in the repository
	 * @return The saved telephone if successful, or null if there is an error
	 *
	 */
	public Telephone execute(Telephone telephone) {
        return this.telephoneRepository.save(telephone);
    }
}
