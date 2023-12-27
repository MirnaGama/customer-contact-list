package com.mirna.customercontactlistapi.application.usecase.telephone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.domain.repositories.TelephoneRepository;

/**
 * This class is used to execute the findAll method from telephone repository
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class FindAllTelephonesUseCase {

	@Autowired
	private TelephoneRepository telephoneRepository;
	
	/**
	 * Executes the findAll method from telephone repository
	 *
	 * @return  A list containing all objects of type Telephone in the repository
	 */
	public List<Telephone> execute() {
        return this.telephoneRepository.findAll();
    }
}
