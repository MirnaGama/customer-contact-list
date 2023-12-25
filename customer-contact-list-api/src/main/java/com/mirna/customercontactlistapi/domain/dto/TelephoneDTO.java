package com.mirna.customercontactlistapi.domain.dto;

/**
* 
* @author Mirna Gama
* @version 1.0
*/
public class TelephoneDTO {

	private String number; 
    private Long customerId;
    
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
    
}
