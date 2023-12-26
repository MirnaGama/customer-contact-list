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
	
	@Override
	public Telephone addTelephone(TelephoneDTO telephoneDTO) throws EntityNotPresentException {
		Telephone telephone = this.telephoneMapper.toTelephoneEntity(telephoneDTO);
		return addTelephone.execute(telephone);
	}

	@Override
	public Telephone addTelephone(Telephone telephone) {
		return addTelephone.execute(telephone);
	}
	
	
}
