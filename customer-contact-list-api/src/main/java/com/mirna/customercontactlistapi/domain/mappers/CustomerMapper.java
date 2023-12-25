package com.mirna.customercontactlistapi.domain.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.dto.CustomerDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;

/**
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class CustomerMapper {

	 	private ModelMapper mapper;
	 
	    public CustomerMapper() {
	    	mapper =  new ModelMapper();
	    }
	    
	    public Customer toCustomerEntity(CustomerDTO customerDTO) {
	        return mapper.map(customerDTO, Customer.class);
	    }

	    public CustomerDTO toUserDTO(Customer customerEntity) {
	        return mapper.map(customerEntity, CustomerDTO.class);
	    }
}
