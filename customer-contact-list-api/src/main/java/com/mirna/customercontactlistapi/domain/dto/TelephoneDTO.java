package com.mirna.customercontactlistapi.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
* 
* @author Mirna Gama
* @version 1.0
*/
public class TelephoneDTO {

	@NotEmpty(message="number cannot be empty")
	private String number; 
	
	@NotNull(message="customerId cannot be empty")
    private Long customerId;
    
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
	 * @return A long representing the customer id. Must not be null.
	 */
	public Long getCustomerId() {
		return customerId;
	}
	
	/**
	 * Sets the customer id
	 * @param customerId The customer's unique identifier related to the telephone
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
    
}
