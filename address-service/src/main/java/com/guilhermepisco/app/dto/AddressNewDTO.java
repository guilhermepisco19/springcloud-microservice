package com.guilhermepisco.app.dto;

import java.io.Serializable;

public class AddressNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String street;

	private String city;

	
	public AddressNewDTO(String street, String city) {
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

	
}
