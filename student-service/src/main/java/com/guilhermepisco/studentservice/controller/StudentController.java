package com.guilhermepisco.studentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilhermepisco.studentservice.dto.StudentNewDTO;
import com.guilhermepisco.studentservice.entity.Student;
import com.guilhermepisco.studentservice.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController extends AbstractController{
	
	@Autowired
	StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Void> createStudent (@RequestBody StudentNewDTO obj) {
		Student newObj = studentService.createStudent(obj);
		return ResponseEntity.created(createResourceURI(newObj)).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getById (@PathVariable long id) {
		return ResponseEntity.ok(studentService.getById(id));
	}
	
}
