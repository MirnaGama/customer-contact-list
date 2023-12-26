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
import com.mirna.customercontactlistapi.domain.services.TelephoneService;
import com.mirna.customercontactlistapi.exceptions.EntityNotPresentException;

import jakarta.validation.Valid;

/**
 * 
 * @author Mirna Gama
 * @version 1.0
 */
@RestController
@RequestMapping("/v1/telephones")
public class TelephoneController {
	
	@Autowired
	private TelephoneService telephoneService;
	
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
