package com.guilhermepisco.app.dto;

import java.io.Serializable;

import com.guilhermepisco.app.entities.Address;

public class AddressDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long adressId;
	
	private String street;

	private String city;

	

	public AddressDTO(Address address) {
		this.adressId = address.getId();
		this.street = address.getStreet();
		this.city = address.getCity();
		
	}

	public AddressDTO(Long adressId, String street, String city) {
		this.adressId = adressId;
		this.street = street;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getAdressId() {
		return adressId;
	}

	public void setAdressId(Long adressId) {
		this.adressId = adressId;
	}
	
}
