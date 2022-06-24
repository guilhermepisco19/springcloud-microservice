package com.guilhermepisco.studentservice.service;

import org.springframework.stereotype.Service;

import com.guilhermepisco.studentservice.dto.StudentNewDTO;
import com.guilhermepisco.studentservice.entity.Student;
import com.guilhermepisco.studentservice.repository.StudentRepository;

@Service
public class StudentService {

	StudentRepository studentRepository;

	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
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
	
	public Student getById (long id) {
		return studentRepository.findById(id).get();
	}
}
