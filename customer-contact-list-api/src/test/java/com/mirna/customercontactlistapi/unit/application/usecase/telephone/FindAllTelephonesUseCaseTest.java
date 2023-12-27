package com.mirna.customercontactlistapi.unit.application.usecase.telephone;

import static org.assertj.core.api.Assertions.assertThat;

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
import com.mirna.customercontactlistapi.application.usecase.telephone.FindAllTelephonesUseCase;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.domain.repositories.CustomerRepository;
import com.mirna.customercontactlistapi.domain.repositories.TelephoneRepository;

@SpringBootTest(classes = CustomerContactListApiApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class FindAllTelephonesUseCaseTest {

	@Autowired
	private FindAllTelephonesUseCase findAllTelephones;
	
	@Autowired
	private TelephoneRepository telephoneRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
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
		
		Telephone telephone = new Telephone();
		telephone.setNumber("(87) 2124-2572");
		telephone.setCustomer(testCustomer);
		
		telephoneRepository.save(telephone);
	}
	
	@AfterAll
	public void terminate() {
		telephoneRepository.deleteAll();
		customerRepository.deleteAll();
	}
	
	/**
	 * Execute findAll method successfully
	 * 
	 * @result All telephones will be fetched from the repository and the size of the
	 *         fetched telephones list afterwards will be greater than zero
	 */
	@Test
	@DisplayName("Should execute findAll method")
	public void testFindAllCustomers() throws Exception {

		List<Telephone> telephones = findAllTelephones.execute();

		assertThat(telephones.size()).isNotZero();
	}
}
