package com.mirna.customercontactlistapi.unit.application.usecase.customer;

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
import com.mirna.customercontactlistapi.application.usecase.customer.FindCustomerByIdUseCase;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.repositories.CustomerRepository;

@SpringBootTest(classes = CustomerContactListApiApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class FindCustomerByIdUseCaseTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FindCustomerByIdUseCase findCustomerById;

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
		customerRepository.deleteAll();
	}

	/**
	 * Execute findById method successfully
	 * 
	 * @result A customer will be returned without any errors, and Customer object
	 *         will not be <code>null</code>
	 */
	@Test
	@DisplayName("Should execute findById method")
	public void testFindCustomerById() throws Exception {

		Customer customer = findCustomerById.execute(testCustomer.getId());

		assertNotNull(customer);
	}
}
