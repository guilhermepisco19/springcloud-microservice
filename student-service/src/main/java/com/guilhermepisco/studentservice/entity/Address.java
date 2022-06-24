package com.guilhermepisco.studentservice.entity;

import java.io.Serializable;


public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

	private String street;

	private String city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
