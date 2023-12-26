package com.mirna.customercontactlistapi.application.usecase.telephone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.repositories.TelephoneRepository;

/**
 * This class is used to execute the deleteAll method from telephone repository
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class DeleteAllTelephonesUseCase {

	@Autowired
	private TelephoneRepository telephoneRepository;
	
	/**
	 * Executes the deleteAll method from telephone repository
	 *
	 */
	public void execute() {
        this.telephoneRepository.deleteAll();
    }
}
