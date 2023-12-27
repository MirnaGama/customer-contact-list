package com.mirna.customercontactlistapi.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mirna.customercontactlistapi.domain.dto.TelephoneDTO;
import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.domain.exceptions.EntityNotPresentException;

/**
 * Telephone service interface for managing telephone information.
 * 
 * @see Telephone
 * @author Mirna Gama
 * @version 1.0
 */
@Service
public interface TelephoneService {

	/**
	 * Adds a new telephone to the repository.
	 * 
	 * @param telephoneDTO A data transfer object representing a telephone to add.
	 * @return The saved telephone if successful, or throw an exception if customer
	 *         id is not valid
	 * @throws com.mirna.customercontactlistapi.domain.exceptions.EntityNotPresentException if the related customer does not exist in the
	 *                                 database.
	 */
	public Telephone addTelephone(TelephoneDTO telephoneDTO) throws EntityNotPresentException;

	/**
	 * Adds a new telephone to the repository.
	 * 
	 * @param telephone The telephone entity to be added.
	 * @return The saved telephone if successful, or null if there is an error.
	 */
	public Telephone addTelephone(Telephone telephone);
	
	/**
	 * Retrieves a list of all telephones.
	 * 
	 * @return  A list containing all objects of type Telephone in the repository
	 */
    public List<Telephone> findAllTelephones();
    
	/**
	 * Deletes all telephones stored in the repository
	 * 
	 */
    public void deleteAllTelephones();
}
