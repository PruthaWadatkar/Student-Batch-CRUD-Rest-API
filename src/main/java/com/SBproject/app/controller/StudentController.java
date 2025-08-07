package com.SBproject.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SBproject.app.model.Student;
import com.SBproject.app.service.StudentService;

@RestController
@RequestMapping(value = "/api/student/")
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	
	@GetMapping(value = "/student/{id}")
 public ResponseEntity<Student> getSingleStudent(@PathVariable Student st){
	 
    Student getstud= studentservice.getSingleStudent(st);
	 
	return new ResponseEntity<Student>(getstud, HttpStatus.OK);
	}
	 
	@GetMapping(value="/batches")
	public ResponseEntity<List<Student>> getAllStudent() {
		
	List<Student> stulist=	studentservice.getAllStudent();		
		
		return new ResponseEntity<List<Student>>(stulist, HttpStatus.OK);
	}
	
	
	
	 
	 
 }



