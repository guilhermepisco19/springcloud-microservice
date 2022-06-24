package com.guilhermepisco.studentservice.dto;

import com.guilhermepisco.studentservice.entity.Address;
import com.guilhermepisco.studentservice.entity.Student;

public class StudentDTO {

	private String firstName;

	private String lastName;

	private String email;

	private Address address;
	
	

	public StudentDTO(Student student, Address address) {
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

}
