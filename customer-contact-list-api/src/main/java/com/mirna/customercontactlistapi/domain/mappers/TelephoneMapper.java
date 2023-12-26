package com.mirna.customercontactlistapi.domain.mappers;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.dto.TelephoneDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.exceptions.EntityNotPresentException;
import com.mirna.customercontactlistapi.repositories.CustomerRepository;

/**
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class TelephoneMapper {

	private ModelMapper mapper;
	
	@Autowired
	private CustomerRepository customerRepository;
	 
    public TelephoneMapper() {
    	mapper =  new ModelMapper();
    }
    
    public Telephone toTelephoneEntity(TelephoneDTO telephoneDTO) throws EntityNotPresentException {
        Telephone telephone = mapper.map(telephoneDTO, Telephone.class);
        
        Optional<Customer> customer = customerRepository.findById(telephoneDTO.getCustomerId());
        
        if (!customer.isPresent()) {
        	throw new EntityNotPresentException("Cliente não existe");
        }
        
        telephone.setCustomer(customer.get());
        return telephone;
    }

    public TelephoneDTO toTelephoneDTO(Telephone telephoneEntity) {
    	TelephoneDTO telephoneDTO = mapper.map(telephoneEntity, TelephoneDTO.class);
    	
    	telephoneDTO.setCustomerId(telephoneEntity.getCustomer().getId());
    	return telephoneDTO;
    }
}
