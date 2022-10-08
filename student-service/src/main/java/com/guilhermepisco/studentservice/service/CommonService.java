package com.guilhermepisco.studentservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.guilhermepisco.studentservice.entity.Address;
import com.guilhermepisco.studentservice.feignclients.AddressFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CommonService.class);
	
	private WebClient webClient;

	private AddressFeignClient addressFeignClient;
	
	long count = 1;
	
	public CommonService(WebClient webClient, AddressFeignClient addressFeignClient) {
		this.webClient = webClient;
		this.addressFeignClient = addressFeignClient;
	}

	@CircuitBreaker(name = "addressService",
			fallbackMethod = "fallbackGetAddressById")
	public Address getAddressByID(long id) {
		/*Mono<Address> address = webClient.get().uri("/"+id).retrieve().bodyToMono(Address.class);
		return address.block();*/
		LOG.info("Count = " + count);
		count++;
		return addressFeignClient.getById(id).getBody();
	}
	
	public Address fallbackGetAddressById(long id, Throwable th) {
		LOG.error("Error = " + th);
		return new Address();
	}
}
