package com.mirna.customercontactlistapi.unit.application.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import com.mirna.customercontactlistapi.CustomerContactListApiApplication;
import com.mirna.customercontactlistapi.application.services.CustomerServiceImpl;
import com.mirna.customercontactlistapi.application.services.TelephoneServiceImpl;
import com.mirna.customercontactlistapi.domain.dto.TelephoneDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.domain.exceptions.EntityNotPresentException;

/**
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@SpringBootTest(classes = CustomerContactListApiApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class TelephoneServiceTest {

	@Autowired
	private TelephoneServiceImpl telephoneService;

	@Autowired
	private CustomerServiceImpl customerService;

	private Telephone testTelephone;

	private Customer testCustomer;

	@BeforeAll
	public void setup() {
		testCustomer = new Customer();
		testCustomer.setCep("5110000");
		testCustomer.setCity("São Paulo");
		testCustomer.setFullname("Maria");
		testCustomer.setHouseNumber(100L);
		testCustomer.setNeighborhood("Jardim Santo Elias");
		testCustomer.setState("SP");
		testCustomer.setStreet("Avenida Mutinga");

		testCustomer = customerService.addCustomer(testCustomer);
	}

	@AfterAll
	public void terminate() {
		telephoneService.deleteAllTelephones();
		customerService.deleteAllCustomers();
	}
	
	/**
	 * Create a valid telephone.
	 * @result Telephone will be persisted without any errors,
	 *         and Telephone.getId() will no longer be <code>null</code>
	 */
	@Test
	@DisplayName("Should add valid telephone")
	public void testAddValidTelephone() throws Exception {
		TelephoneDTO telephoneDTO = new TelephoneDTO();
		telephoneDTO.setNumber("(87) 2124-2572");
		telephoneDTO.setCustomerId(testCustomer.getId());
		
		Telephone telephone = telephoneService.addTelephone(telephoneDTO);
		
		assertNotNull(telephone.getId());
	}
	
	/**
	 * Avoid creating a telephone with a non-existent related customer
	 * @result Telephone will not be persisted 
	 *         and <code>com.mirna.customercontactlistapi.domain.exceptions.EntityNotPresentException</code> will be thrown instead
	 */
	@Test
	@DisplayName("Should not add telephone with a non-existent related customer")
	public void testAddInvalidCustomerTelephone() throws Exception {
		TelephoneDTO telephoneDTO = new TelephoneDTO();
		telephoneDTO.setNumber("(87) 2124-2572");
		telephoneDTO.setCustomerId(UUID.randomUUID());
		
		assertThrows(EntityNotPresentException.class, () -> telephoneService.addTelephone(telephoneDTO));
	}
	
	/**
	 * Avoid creating a telephone with a null number value
	 * @result Telephone will not be persisted 
	 *         and <code>org.springframework.transaction.TransactionSystemException</code> will be thrown instead
	 */
	@Test
	@DisplayName("Should not add telephone with a null number value")
	public void testAddInvalidNumberTelephone() throws Exception {
		TelephoneDTO telephoneDTO = new TelephoneDTO();
		telephoneDTO.setNumber("");
		telephoneDTO.setCustomerId(testCustomer.getId());
		
		assertThrows(TransactionSystemException.class, () -> telephoneService.addTelephone(telephoneDTO));
	}
	
	/**
	 * Avoid creating a telephone with invalid number format
	 * @result Telephone will not be persisted 
	 *         and <code>org.springframework.transaction.TransactionSystemException</code> will be thrown instead
	 */
	@Test
	@DisplayName("Should not add telephone with invalid number format")
	public void testAddInvalidNumberFormatTelephone() throws Exception {
		TelephoneDTO telephoneDTO = new TelephoneDTO();
		telephoneDTO.setNumber("(87) 2124");
		telephoneDTO.setCustomerId(testCustomer.getId());
		
		assertThrows(TransactionSystemException.class, () -> telephoneService.addTelephone(telephoneDTO));
	}
	
	/**
	 * Finds all telephones stored in the database
	 * @result A list of objects of type Telephone will be returned without any errors,
	 *         and the size of this list will be greater than zero
	 */
	@Test
	@DisplayName("Should find all telephones")
	public void testFindAllCustomers() throws Exception {
		
		List<Telephone> telephones = telephoneService.findAllTelephones();
		
		assertThat(telephones.size()).isNotZero();
	}
	
}
