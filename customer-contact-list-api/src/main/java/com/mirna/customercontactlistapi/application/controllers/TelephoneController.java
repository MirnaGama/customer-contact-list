package com.mirna.customercontactlistapi.application.controllers;

import java.util.HashMap;
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
@RequestMapping("/api/v1/telephones")
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
	
    
}
