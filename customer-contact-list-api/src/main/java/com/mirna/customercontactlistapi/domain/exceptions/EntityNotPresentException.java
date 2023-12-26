package com.mirna.customercontactlistapi.domain.exceptions;

/**
 *  A custom exception class used to indicate that the specified entity cannot be found using the provided identifier.
*
 * @author Mirna Gama
* @version 1.0
*/
public class EntityNotPresentException extends Exception {

	public EntityNotPresentException(String message) {
		super(message);
	}
}
