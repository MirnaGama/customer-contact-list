package com.mirna.customercontactlistapi.unit.application.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mirna.customercontactlistapi.CustomerContactListApiApplication;
import com.mirna.customercontactlistapi.application.services.CustomerServiceImpl;
import com.mirna.customercontactlistapi.domain.dto.CustomerDTO;
import com.mirna.customercontactlistapi.domain.entities.Customer;

/**
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@SpringBootTest(classes = CustomerContactListApiApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class CustomerServiceTest {

    @Autowired
    private CustomerServiceImpl customerService;

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
    
	/**
	 * Create a valid customer.
	 * @result Customer will be persisted without any errors,
	 *         and Customer.getId() will no longer be <code>null</code>
	 */
	@Test
	@DisplayName("Should add valid customer")
	public void testAddValidCustomer() throws Exception {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setCep("09220440");
		customerDTO.setCity("Santo André");
		customerDTO.setFullname("José");
		customerDTO.setHouseNumber(100L);
		customerDTO.setNeighborhood("Utinga");
		customerDTO.setState("SP");
		customerDTO.setStreet("Rua Havana");
		
		Customer customer = customerService.addCustomer(customerDTO);
		
		assertNotNull(customer.getId());
	}
	
	/**
	 * Finds a customer by the provided ID
	 * @result A customer will be returned without any errors,
	 *         and Customer object will not be <code>null</code>
	 */
	@Test
	@DisplayName("Should find customer by ID")
	public void testFindCustomerById() throws Exception {
		
		Customer customer = customerService.findCustomerById(testCustomer.getId());
		assertNotNull(customer);
	}
	
	/**
	 * Finds all customers stored in the database
	 * @result A list of objects of type Customer will be returned without any errors,
	 *         and the size of this list will be greater than zero
	 */
	@Test
	@DisplayName("Should find all customers")
	public void testFindAllCustomers() throws Exception {
		
		List<Customer> customers = customerService.findAllCustomers();
		
		assertThat(customers.size()).isNotZero();
	}
}
