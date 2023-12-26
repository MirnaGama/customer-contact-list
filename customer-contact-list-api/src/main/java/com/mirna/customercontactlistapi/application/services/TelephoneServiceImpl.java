package com.mirna.customercontactlistapi.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mirna.customercontactlistapi.application.usecase.telephone.AddTelephoneUseCase;
import com.mirna.customercontactlistapi.domain.dto.TelephoneDTO;
import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.domain.mappers.TelephoneMapper;
import com.mirna.customercontactlistapi.domain.services.TelephoneService;
import com.mirna.customercontactlistapi.exceptions.EntityNotPresentException;

/**
 * This class is an implementation of the TelephoneService interface.
 *
 * This class provides methods to perform operations on telephones
 *
 * @author Mirna Gama
 * @version 1.0
 */
@Service
public class TelephoneServiceImpl implements TelephoneService {

	@Autowired
	private AddTelephoneUseCase addTelephone;

	@Autowired
	private TelephoneMapper telephoneMapper;

	/**
	 * Adds a new telephone to the database.
	 *
	 * @param telephoneDTO A data transfer object containing the data for Telephone
	 *                     entity.
	 * @return The saved telephone if successful, or throw an exception if customer
	 *         id is not valid
	 * @throws EntityNotFoundException if the related customer does not exist in the
	 *                                 database.
	 */
	@Override
	public Telephone addTelephone(TelephoneDTO telephoneDTO) throws EntityNotPresentException {
		Telephone telephone = this.telephoneMapper.toTelephoneEntity(telephoneDTO);
		return addTelephone.execute(telephone);
	}

	/**
	 * Adds a new telephone to the database.
	 *
	 * @param telephone a Telephone entity representing the new telephone record.
	 * @return The saved telephone if successful, or null if there is an error.
	 */
	@Override
	public Telephone addTelephone(Telephone telephone) {
		return addTelephone.execute(telephone);
	}

}