package com.mirna.customercontactlistapi.domain.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

/**
* 
* @author Mirna Gama
* @version 1.0
*/
@Entity(name="customers")
public class Customer {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@NotEmpty(message = "cep cannot be empty")
	@Column(name = "cep")
	private String cep;

	@NotEmpty(message = "city cannot be empty")
	@Column(name = "city")
	private String city;

	@NotEmpty(message = "fullname cannot be empty")
	@Column(name = "full_name")
	private String fullname;

	@Min(value = 1, message = "houseNumber must be greater than zero")
	@Column(name = "house_number")
	private Long houseNumber;

	@NotEmpty(message = "neighborhood cannot be empty")
	@Column(name = "neighborhood")
	private String neighborhood;

	@NotEmpty(message = "state cannot be empty")
	@Column(name = "state")
	private String state;

	@NotEmpty(message = "street cannot be empty")
	@Column(name = "street")
	private String street;

	/** 
	 * Represents the customer’s telephones.
	*/
	@OneToMany(mappedBy="customer")
	@JsonIgnore
	private List<Telephone> telephones;

	/**
	 *  Returns the customer id.
	 * @return A UUID representing the customer id.
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Sets the customer id.
	 * @param id The customer's unique identifier.
	 */
	public void setId(UUID id) {
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
	 * @param cep The customer's street postal code. Must not be empty.
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
	 * @param city The city where the customer lives. Must not be empty.
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
	 * @param fullname The customer's first and last name. Must not be empty.
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
	 * @param houseNumber The number of the house where the customer lives. Must be greater than zero.
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
	 * @param neighborhood The neighborhood where the customer lives. Must not be empty.
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	/**
	  * Returns the state
	 * @return A string representing the customer's state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state
	 * @param state The state where the customer lives. Must not be empty.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	  * Returns the street
	 * @return A string representing the customer's street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the street
	 * @param street The street where the customer lives. Must not be empty.
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