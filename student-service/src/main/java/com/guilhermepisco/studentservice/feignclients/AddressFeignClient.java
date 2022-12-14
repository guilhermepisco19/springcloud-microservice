package com.guilhermepisco.studentservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.guilhermepisco.studentservice.entity.Address;

@FeignClient(value = "address-service", path = "/api/address")
public interface AddressFeignClient {
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> getById(@PathVariable Long id);
	
}
