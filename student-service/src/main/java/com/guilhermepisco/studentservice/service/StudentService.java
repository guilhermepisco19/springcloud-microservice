package com.guilhermepisco.studentservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.guilhermepisco.studentservice.dto.StudentDTO;
import com.guilhermepisco.studentservice.dto.StudentNewDTO;
import com.guilhermepisco.studentservice.entity.Address;
import com.guilhermepisco.studentservice.entity.Student;
import com.guilhermepisco.studentservice.repository.StudentRepository;

import reactor.core.publisher.Mono;

@Service
public class StudentService {

	private StudentRepository studentRepository;
	
	private WebClient webClient;

	
	public StudentService(StudentRepository studentRepository, WebClient webClient) {
		this.studentRepository = studentRepository;
		this.webClient = webClient;
	}

	public Student createStudent(StudentNewDTO obj) {

		Student student = new Student();
		student.setFirstName(obj.getFirstName());
		student.setLastName(obj.getLastName());
		student.setEmail(obj.getEmail());
		
		student.setAddressId(obj.getAddressId());
		student = studentRepository.save(student);

		return student;
	}
	
	public StudentDTO getById (long id) {
		Student student = studentRepository.findById(id).get();
		Address address = getAddressByID(student.getAddressId());
		
		return new StudentDTO(student, address);
	}
	
	public Address getAddressByID(long id) {
		Mono<Address> address = webClient.get().uri("/"+id).retrieve().bodyToMono(Address.class);
		
		return address.block();
	}
}
