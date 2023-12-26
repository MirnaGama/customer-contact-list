package com.mirna.customercontactlistapi.unit.application.usecase.customer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mirna.customercontactlistapi.application.usecase.customer.FindAllCustomersUseCase;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.repositories.CustomerRepository;

public class FindAllCustomersUseCaseTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FindAllCustomersUseCase findAllCustomers;

	@BeforeAll
	public void setup() {
		Customer testCustomer = new Customer();
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
	 * Execute findAll method successfully
	 * 
	 * @result All customers will be fetched from the repository and the size of the
	 *         fetched customer list afterwards will be greater than zero
	 */
	@Test
	@DisplayName("Should execute findAll method")
	public void testFindAllCustomers() throws Exception {

		List<Customer> customers = findAllCustomers.execute();

		assertThat(customers.size()).isNotZero();
	}
}
