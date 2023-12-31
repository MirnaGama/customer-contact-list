package com.mirna.customercontactlistapi.application.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mirna.customercontactlistapi.domain.dto.TelephoneDTO;
import com.mirna.customercontactlistapi.domain.entities.Telephone;
import com.mirna.customercontactlistapi.domain.exceptions.EntityNotPresentException;
import com.mirna.customercontactlistapi.domain.services.TelephoneService;

import jakarta.validation.Valid;

/**
 * A Spring REST controller for managing telephones.
 *
 * @author Mirna Gama
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1.0/telephones")
public class TelephoneController {
	
	@Autowired
	private TelephoneService telephoneService;
	
	/**
	 * Post method to create a new Telephone object based on the provided DTO.
	 *
	 * @param telephoneDTO The data transfer object containing data for Telephone
	 * entity.
	 * 
	 * @return A response entity containing the saved telephone if successful, or
	 * a 400-level error if there is a validation error
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> addTelephone(@RequestBody @Valid TelephoneDTO telephoneDTO) {
		
		Telephone telephone = null;
		try {
			telephone = telephoneService.addTelephone(telephoneDTO);
		} catch (EntityNotPresentException exception) {
			Map<String, Object> body = new HashMap<>();
			body.put("message", exception.getMessage());

			return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		return ResponseEntity.ok(telephone);
	}
	
	/**
	 * Get method to receive a list of all objects of type Telephone stored in the database.
	 * 
	 * @return A response entity containing the list of telephones if successful, or
	 * null if there is none
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getAllTelephones() {
		
		List<Telephone> telephones = telephoneService.findAllTelephones();
		return ResponseEntity.ok(telephones);
	}
	
    
}
