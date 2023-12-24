package com.mirna.customercontactlistapi.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
* 
* @author Mirna Gama
* @version 1.0
*/
@Entity(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "house_number")
	private Long houseNumber;
	
	@Column(name = "neighborhood")
	private String neighborhood;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "street")
	private String street;
	
	/** 
	 * Represents the customer’s telephones.
	*/
	@OneToMany(mappedBy="customer")
	private List<Telephone> telephones;

	/**
	 *  Returns the customer id.
	 * @return A long representing the customer id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the customer id.
	 * @param id The customer's unique identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Returns the cep
	 * @return A string representing the cep.
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Sets the cep
	 * @param cep The customer's street postal code. Must not be null.
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	  * Returns the city
	 * @return A string representing the customer's city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city
	 * @param city The city where the customer lives. Must not be null.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	  * Returns the full name
	 * @return A string representing the customer's full name.
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * Sets the full name
	 * @param fullname The customer's first and last name. Must not be null.
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	  * Returns the house number
	 * @return A long representing the customer's house number.
	 */
	public Long getHouseNumber() {
		return houseNumber;
	}

	/**
	 * Sets the house number
	 * @param houseNumber The number of the house where the customer lives. Must not be null.
	 */
	public void setHouseNumber(Long houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	  * Returns the neighborhood
	 * @return A string representing the customer's neighborhood.
	 */
	public String getNeighborhood() {
		return neighborhood;
	}

	/**
	 * Sets the neighborhood
	 * @param neighborhood The neighborhood where the customer lives. Must not be null.
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	/**
	  * Returns the state
	 * @return A string representing the customer's state
	 */
	public String Returnstate() {
		return state;
	}

	/**
	 * Sets the state
	 * @param state The state where the customer lives. Must not be null.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	  * Returns the street
	 * @return A string representing the customer's street
	 */
	public String Returnstreet() {
		return street;
	}

	/**
	 * Sets the street
	 * @param street The street where the customer lives. Must not be null.
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	  * Returns the telephones
	 * @return A list containing objects of type Telephone representing the customer's telephone numbers
	 */
	public List<Telephone> getTelephones() {
		return telephones;
	}

	/**
	 * Sets the street
	 * @param telephones The customer's phone list. 
	 */
	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}

}
