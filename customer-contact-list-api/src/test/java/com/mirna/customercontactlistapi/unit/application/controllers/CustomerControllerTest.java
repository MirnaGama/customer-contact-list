package com.mirna.customercontactlistapi.unit.application.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mirna.customercontactlistapi.domain.dto.CustomerDTO;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	/**
	 * Post a valid customer.
	 * @result Customer will be persisted without any errors,
	 *         and http status will be <code>200 (OK)</code>
	 */
	@Test
	@DisplayName("Should post valid customer and return http status ok")
	public void testPostValidCustomer() throws Exception {

		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCep("09220440");
		customerDTO.setCity("Santo André");
		customerDTO.setFullname("José");
		customerDTO.setHouseNumber(100L);
		customerDTO.setNeighborhood("Utinga");
		customerDTO.setState("SP");
		customerDTO.setStreet("Rua Havana");

		String customerDTOContent = mapper.writeValueAsString(customerDTO);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/customers").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8").content(customerDTOContent))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}
}
