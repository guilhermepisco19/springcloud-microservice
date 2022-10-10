package com.guilhermepisco.app.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guilhermepisco.app.dto.AddressNewDTO;
import com.guilhermepisco.app.entities.Address;
import com.guilhermepisco.app.services.AddressService;

@RestController
@RequestMapping(value="/api/address")
@RefreshScope
public class AddressController {
	
	private AddressService service;
	
	@Value("${test.key:default}")
	String testValue;
	
	@Autowired
	public AddressController(AddressService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Void> createAddress(@RequestBody AddressNewDTO obj) {
		
		Address newObj = service.createAddress(service.fromDTO(obj));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> getById(@PathVariable Long id) {
		Address response = service.getById(id);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> getById() {
		return ResponseEntity.ok(testValue);
	}

}
