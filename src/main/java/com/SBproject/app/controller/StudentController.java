package com.SBproject.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SBproject.app.model.Batch;
import com.SBproject.app.model.Student;
import com.SBproject.app.service.StudentService;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@RestController
@RequestMapping(value = "/api/student/")
public class StudentController {

	private static final String List = null;
	@Autowired
	StudentService service;
	
	@PostMapping("/students")
	public ResponseEntity<Student>  post(@RequestBody Student  student){
		
		Student students=service.post(student);
		return new ResponseEntity<Student>(students,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/students/{bid}/{id}")
	public ResponseEntity<Student> put(@RequestBody Student student,@PathVariable Integer bid,@PathVariable Integer id){
		Student students=service.put(student,bid, id);
		return new ResponseEntity<Student>(students,HttpStatus.ACCEPTED);
	
	}

	
	@GetMapping("/students/pagination")
	public ResponseEntity<java.util.List<Student>> pagination(@RequestParam int page,@RequestParam int size ){
		java.util.List<Student> students=service.pagination(page,size);
		
		return new ResponseEntity<java.util.List<Student>>(students,HttpStatus.ACCEPTED);
		
	}
	

}
