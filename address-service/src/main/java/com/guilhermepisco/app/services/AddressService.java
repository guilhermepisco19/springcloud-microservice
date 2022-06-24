package com.guilhermepisco.app.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import com.guilhermepisco.app.dto.AddressNewDTO;
import com.guilhermepisco.app.entities.Address;
import com.guilhermepisco.app.repositories.AddressRepository;

@Service
public class AddressService {

	private AddressRepository repo;
	
	private AddressService(AddressRepository repository) {
		this.repo = repository;
	}
	
	public Address createAddress(Address obj) {
		return repo.save(obj);
	}
	
	public Address getById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Address"));
	}
	
	
	public Address fromDTO(AddressNewDTO newDto) {
		Address obj = new Address();
		
		obj.setCity(newDto.getCity());
		obj.setStreet(newDto.getStreet());
		
		return obj;
	}
}
