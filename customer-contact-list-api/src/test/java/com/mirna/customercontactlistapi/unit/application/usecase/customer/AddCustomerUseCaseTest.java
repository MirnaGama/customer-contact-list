package com.mirna.customercontactlistapi.unit.application.usecase.customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mirna.customercontactlistapi.CustomerContactListApiApplication;
import com.mirna.customercontactlistapi.application.usecase.customer.AddCustomerUseCase;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.repositories.CustomerRepository;

@SpringBootTest(classes = CustomerContactListApiApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class AddCustomerUseCaseTest {

	@Autowired
	private AddCustomerUseCase addCustomer;
	
	@Autowired
	private CustomerRepository customerRepository;

	@AfterAll
	public void terminate() {
		customerRepository.deleteAll();
	}
	
	/**
	 * Should execute save method successfully
	 * 
	 * @result Customer will be persisted without any errors, and Customer.getId()
	 *         will no longer be <code>null</code>
	 */
	@Test
	@DisplayName("Should execute save method")
	public void testAddCustomer() throws Exception {
		Customer customer = new Customer();
		customer.setCep("09220440");
		customer.setCity("Santo André");
		customer.setFullname("José");
		customer.setHouseNumber(100L);
		customer.setNeighborhood("Utinga");
		customer.setState("SP");
		customer.setStreet("Rua Havana");

		customer = addCustomer.execute(customer);

		assertNotNull(customer.getId());
	}
}
