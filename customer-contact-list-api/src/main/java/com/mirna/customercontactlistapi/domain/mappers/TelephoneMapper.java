package com.mirna.customercontactlistapi.domain.mappers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.dto.TelephoneDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.exceptions.EntityNotPresentException;
import com.mirna.customercontactlistapi.repositories.CustomerRepository;

/**
 * This mapper provides functionality for converting between Telephone entity
 * class and matching data transfer objects
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class TelephoneMapper {
	
	@Autowired
	private CustomerRepository customerRepository;
    
	/**
	 * Returns a entity object of type Telephone
	 * 
	 * @param telephoneDTO Data transfer object that will be converted
	 * @return Mapped telephone entity
	 */
    public Telephone toTelephoneEntity(TelephoneDTO telephoneDTO) throws EntityNotPresentException {
        Telephone telephone = new Telephone();
        
        Optional<Customer> customer = customerRepository.findById(telephoneDTO.getCustomerId());
        
        if (!customer.isPresent()) {
        	throw new EntityNotPresentException("Cliente não existe");
        }
        
        telephone.setCustomer(customer.get());
        telephone.setNumber(telephoneDTO.getNumber());
        return telephone;
    }

    /**
	 * Returns a data transfer object containing Telephone entity data
	 * 
	 * @param telephoneEntity Entity object that will be converted
	 * @return Mapped telephone data transfer object
	 */
    public TelephoneDTO toTelephoneDTO(Telephone telephoneEntity) {
    	TelephoneDTO telephoneDTO = new TelephoneDTO();
    	
    	telephoneDTO.setCustomerId(telephoneEntity.getCustomer().getId());
    	telephoneDTO.setNumber(telephoneEntity.getNumber());
    	return telephoneDTO;
    }
}
