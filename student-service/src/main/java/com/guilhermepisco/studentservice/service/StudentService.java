package com.guilhermepisco.studentservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.guilhermepisco.studentservice.dto.StudentDTO;
import com.guilhermepisco.studentservice.dto.StudentNewDTO;
import com.guilhermepisco.studentservice.entity.Address;
import com.guilhermepisco.studentservice.entity.Student;
import com.guilhermepisco.studentservice.feignclients.AddressFeignClient;
import com.guilhermepisco.studentservice.repository.StudentRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	private StudentRepository studentRepository;
	
	private WebClient webClient;

	private AddressFeignClient addressFeignClient;
	
	public StudentService(StudentRepository studentRepository, WebClient webClient, AddressFeignClient addressFeignClient) {
		this.studentRepository = studentRepository;
		this.webClient = webClient;
		this.addressFeignClient = addressFeignClient;
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
		//Address address = getAddressByID(student.getAddressId());
		Address address = getAddressByID(student.getAddressId());
		
		return new StudentDTO(student, address);
	}
	
	@CircuitBreaker(name = "addressService",
			fallbackMethod = "fallbackGetAddressById")
	public Address getAddressByID(long id) {
		/*Mono<Address> address = webClient.get().uri("/"+id).retrieve().bodyToMono(Address.class);
		return address.block();*/
		return addressFeignClient.getById(id).getBody();
	}
	
	public Address fallbackGetAddressById(long id) {
		return new Address();
	}
}
