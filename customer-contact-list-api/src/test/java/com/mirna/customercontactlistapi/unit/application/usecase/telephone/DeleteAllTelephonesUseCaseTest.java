package com.mirna.customercontactlistapi.unit.application.usecase.telephone;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mirna.customercontactlistapi.CustomerContactListApiApplication;
import com.mirna.customercontactlistapi.application.usecase.telephone.DeleteAllTelephonesUseCase;
import com.mirna.customercontactlistapi.domain.entities.Customer;
import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.repositories.CustomerRepository;
import com.mirna.customercontactlistapi.repositories.TelephoneRepository;

@SpringBootTest(classes = CustomerContactListApiApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class DeleteAllTelephonesUseCaseTest {
	
	@Autowired
	private DeleteAllTelephonesUseCase deleteAllTelephones;
	
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
	
	/**
	 * Execute delete method successfully
	 * 
	 * @result All telephones will be deleted from the repository and the size of the fetched telephones list afterwards will be zero
	 */
	@Test
	@DisplayName("Should execute delete method")
	public void testDeleteAllCustomers() throws Exception {
		deleteAllTelephones.execute();
		
		List<Telephone> telephones = telephoneRepository.findAll();
		
		assertThat(telephones.size()).isZero();
	}
}
