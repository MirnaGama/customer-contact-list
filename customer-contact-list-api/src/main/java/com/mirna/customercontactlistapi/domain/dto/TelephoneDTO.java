package com.mirna.customercontactlistapi.domain.dto;

import java.util.UUID;

import com.mirna.customercontactlistapi.domain.entities.validation.TelephoneNumberRegex;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
* 
* @author Mirna Gama
* @version 1.0
*/
public class TelephoneDTO {

	@NotEmpty(message="number cannot be empty")
	@Pattern(regexp=TelephoneNumberRegex.VALUE, message="invalid format for number")
	private String number; 
	
	@NotNull(message="customerId cannot be null")
	private UUID customerId;
    
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
	 *  Returns the telephone id
	 * @return A UUID representing the customer id. Must not be null.
	 */
	public UUID getCustomerId() {
		return customerId;
	}
	
	/**
	 * Sets the customer id
	 * @param customerId The customer's unique identifier related to the telephone
	 */
	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}
    
}
