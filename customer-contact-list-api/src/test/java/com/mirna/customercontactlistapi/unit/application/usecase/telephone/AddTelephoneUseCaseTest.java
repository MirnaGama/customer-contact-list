package com.mirna.customercontactlistapi.unit.application.usecase.telephone;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mirna.customercontactlistapi.CustomerContactListApiApplication;
import com.mirna.customercontactlistapi.application.usecase.telephone.AddTelephoneUseCase;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.domain.repositories.CustomerRepository;
import com.mirna.customercontactlistapi.domain.repositories.TelephoneRepository;

@SpringBootTest(classes = CustomerContactListApiApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class AddTelephoneUseCaseTest {

	@Autowired
	private AddTelephoneUseCase addTelephone;
	
	@Autowired
	private TelephoneRepository telephoneRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

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

		testCustomer = customerRepository.save(testCustomer);
	}
	
	@AfterAll
	public void terminate() {
		telephoneRepository.deleteAll();
		customerRepository.deleteAll();
	}
	
	/**
	 * Should execute save method successfully
	 * 
	 * @result Telephone will be persisted without any errors, and Telephone.getId()
	 *         will no longer be <code>null</code>
	 */
	@Test
	@DisplayName("Should execute save method")
	public void testAddTelephone() throws Exception {
		Telephone telephone = new Telephone();
		telephone.setNumber("(87) 2124-2572");
		telephone.setCustomer(testCustomer);
		
		telephone = addTelephone.execute(telephone);

		assertNotNull(telephone.getId());
	}
	
}
