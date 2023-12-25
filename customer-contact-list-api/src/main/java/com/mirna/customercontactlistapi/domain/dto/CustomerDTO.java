package com.mirna.customercontactlistapi.domain.dto;

/**
* 
* @author Mirna Gama
* @version 1.0
*/
public class CustomerDTO {

	private String cep;
	private String city;
	private String fullname;
	private Long houseNumber;
    private String neighborhood;
    private String state;
    private String street;
    
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Long getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(Long houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
    
}
