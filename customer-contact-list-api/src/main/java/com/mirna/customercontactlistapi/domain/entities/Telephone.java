package com.mirna.customercontactlistapi.domain.entities;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.mirna.customercontactlistapi.domain.entities.validation.TelephoneNumberRegex;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
* 
* @author Mirna Gama
* @version 1.0
*/
@Entity(name="telephones")
public class Telephone {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@NotEmpty(message = "número não pode ser vazio")
	@Column(name = "number", unique = true)
	@Pattern(regexp=TelephoneNumberRegex.VALUE, message="formato de número de telefone invalido")
	private String number;
	
	/** 
	 * Represents the customer related to this telephone.
	*/
	@NotNull(message="cliente não pode ser nulo")
	@ManyToOne
	@Valid
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;

	/**
	 *  Returns the telephone id.
	 * @return A UUID representing the telephone id.
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Sets the telephone id
	 * @param id The telephone's unique identifier.
	 */
	public void setId(UUID id) {
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
	 * @param number The telephone number. Must be unique and not empty.
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
