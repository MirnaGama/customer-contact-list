package com.mirna.customercontactlistapi.unit.application.controllers;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mirna.customercontactlistapi.domain.dto.CustomerDTO;
import com.mirna.customercontactlistapi.domain.dto.TelephoneDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TelephoneControllerTest {


	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;
	
	private Customer testCustomer;

	@BeforeAll
	public void setUp() throws Exception {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCep("09220440");
		customerDTO.setCity("Santo André");
		customerDTO.setFullname("José");
		customerDTO.setHouseNumber(100L);
		customerDTO.setNeighborhood("Utinga");
		customerDTO.setState("SP");
		customerDTO.setStreet("Rua Havana");

		String customerDTOContent = mapper.writeValueAsString(customerDTO);

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/v1/customers").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(customerDTOContent))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		
		String content = result.getResponse().getContentAsString();
		
		testCustomer = mapper.readValue(content, Customer.class);
	}
	
	/**
	 * Post a valid telephone.
	 * @result Telephone will be persisted without any errors,
	 *         and http status will be <code>200 (OK)</code>
	 */
	@Test
	@DisplayName("Should post valid customer and return http status OK")
	public void testPostTelephoneCustomer() throws Exception {
		TelephoneDTO telephoneDTO = new TelephoneDTO();
		telephoneDTO.setCustomerId(testCustomer.getId());
		telephoneDTO.setNumber("(87) 3448-8423");
		
		String telephoneDTOContent = mapper.writeValueAsString(telephoneDTO);

		mockMvc.perform(MockMvcRequestBuilders.post("/v1/telephones").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(telephoneDTOContent))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}
	
	/**
	 * Avoid posting a telephone with a non-existent related customer
	 * @result Telephone will not be posted 
	 *         and http status will be <code>422 (Unprocessable Entity)</code>
	 */
	@Test
	@DisplayName("Should not post telephone with a non-existent related customer and return http status Unprocessable Entity")
	public void testPostInvalidCustomerTelephone() throws Exception {
		TelephoneDTO telephoneDTO = new TelephoneDTO();
		telephoneDTO.setNumber("(87) 2124-2572");
		telephoneDTO.setCustomerId(UUID.randomUUID());
		
		String telephoneDTOContent = mapper.writeValueAsString(telephoneDTO);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/telephones").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(telephoneDTOContent))
				.andExpect(MockMvcResultMatchers.status().isUnprocessableEntity()).andDo(MockMvcResultHandlers.print());
	}
	
	/**
	 * Avoid posting a telephone with a null number value
	 * @result Telephone will not be posted 
	 *         and http status will be <code>400 (Bad Request)</code>
	 */
	@Test
	@DisplayName("Should not post telephone with a null number value and return http status Bad Request")
	public void testPostInvalidNumberTelephone() throws Exception {
		TelephoneDTO telephoneDTO = new TelephoneDTO();
		telephoneDTO.setNumber("");
		telephoneDTO.setCustomerId(testCustomer.getId());
		
		String telephoneDTOContent = mapper.writeValueAsString(telephoneDTO);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/telephones").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(telephoneDTOContent))
				.andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(MockMvcResultHandlers.print());
	}
	
	/**
	 * Avoid posting a telephone with invalid number format
	 * @result Telephone will not be posted 
	 *         and http status will be <code>400 (Bad Request)</code>
	 */
	@Test
	@DisplayName("Should not post telephone with invalid number format and return http status Bad Request")
	public void testPostInvalidNumberFormatTelephone() throws Exception {
		TelephoneDTO telephoneDTO = new TelephoneDTO();
		telephoneDTO.setNumber("(87) 2124");
		telephoneDTO.setCustomerId(testCustomer.getId());
		
		String telephoneDTOContent = mapper.writeValueAsString(telephoneDTO);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/v1/telephones").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(telephoneDTOContent))
				.andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(MockMvcResultHandlers.print());
	}
}
