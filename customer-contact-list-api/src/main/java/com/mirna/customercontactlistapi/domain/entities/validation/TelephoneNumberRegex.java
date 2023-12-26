package com.mirna.customercontactlistapi.domain.entities.validation;

/**
 * This class has the value of the regex used to check for the valid format of the phone number
 * 
 * @author Mirna Gama
 * @version 1.0
 */
public class TelephoneNumberRegex {

	public static final String VALUE = "^1\\d\\d(\\d\\d)?$|^0800 ?\\d{3} ?\\d{4}$|^(\\(0?([1-9a-zA-Z][0-9a-zA-Z])?[1-9]\\d\\) ?|0?([1-9a-zA-Z][0-9a-zA-Z])?[1-9]\\d[ .-]?)?(9|9[ .-])?[2-9]\\d{3}[ .-]?\\d{4}$";
}
