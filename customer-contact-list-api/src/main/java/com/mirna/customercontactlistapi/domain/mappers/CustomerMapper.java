package com.mirna.customercontactlistapi.domain.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mirna.customercontactlistapi.domain.dto.CustomerDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;

/**
 * This mapper provides functionality for converting between Customer entity
 * class and matching data transfer objects using
 * com.fasterxml.jackson.databind.ObjectMapper
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@Component
public class CustomerMapper {

	private ModelMapper mapper;

	public CustomerMapper() {
		mapper = new ModelMapper();
	}

	/**
	 * Returns a entity object of type Customer
	 * 
	 * @param customerDTO Data transfer object that will be converted
	 * @return Mapped customer entity
	 */
	public Customer toCustomerEntity(CustomerDTO customerDTO) {
		return mapper.map(customerDTO, Customer.class);
	}

	/**
	 * Returns a data transfer object containing Customer entity data
	 * 
	 * @param customerEntity Entity object that will be converted
	 * @return Mapped customer data transfer object
	 */
	public CustomerDTO toUserDTO(Customer customerEntity) {
		return mapper.map(customerEntity, CustomerDTO.class);
	}
}
