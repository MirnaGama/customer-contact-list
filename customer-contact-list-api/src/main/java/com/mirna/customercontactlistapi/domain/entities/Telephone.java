package com.mirna.customercontactlistapi.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
* 
* @author Mirna Gama
* @version 1.0
*/
@Entity(name="customers")
public class Telephone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "number")
	private String number;
	
	/** 
	 * Represents the customer related to this telephone.
	*/
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	/**
	 *  Returns the telephone id.
	 * @return A long representing the telephone id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the telephone id
	 * @param id The telephone's unique identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 *  Returns the telephone id
	 * @return A string representing the telephone number.
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets the telephone number
	 * @param number The telephone number. Must be unique and not null.
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 *  Returns the customer
	 * @return An object of type Customer that represents the customer related to the telephone
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer
	 * @param customer The customer related to the telephone. Must not be null.
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
