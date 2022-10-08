package com.guilhermepisco.studentservice.service;

import org.springframework.stereotype.Service;

import com.guilhermepisco.studentservice.dto.StudentDTO;
import com.guilhermepisco.studentservice.dto.StudentNewDTO;
import com.guilhermepisco.studentservice.entity.Address;
import com.guilhermepisco.studentservice.entity.Student;
import com.guilhermepisco.studentservice.repository.StudentRepository;

@Service
public class StudentService {

	private StudentRepository studentRepository;
	
	private CommonService commonService;
	
	public StudentService(StudentRepository studentRepository, CommonService commonService) {
		this.studentRepository = studentRepository;
		this.commonService = commonService;
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
		Address address = commonService.getAddressByID(student.getAddressId());
		
		return new StudentDTO(student, address);
	}
	
	
}
