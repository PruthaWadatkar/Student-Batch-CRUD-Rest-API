package com.SBproject.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SBproject.app.model.Student;
import com.SBproject.app.service.StudentService;

@RestController
@RequestMapping(value = "/api/student/")
public class StudentController {



	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/students")
	public ResponseEntity<Student>  post(@RequestBody Student  student){
		
		Student students=studentservice.post(student);
		return new ResponseEntity<Student>(students,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/students/{bid}/{id}")
	public ResponseEntity<Student> put(@RequestBody Student student,@PathVariable Integer bid,@PathVariable Integer id){
		Student students=studentservice.put(student,bid, id);
		return new ResponseEntity<Student>(students,HttpStatus.ACCEPTED);
	
	}

	
	@GetMapping("/students/pagination")
	public ResponseEntity<java.util.List<Student>> pagination(@RequestParam int page,@RequestParam int size ){
		java.util.List<Student> students=studentservice.pagination(page,size);
		
		return new ResponseEntity<java.util.List<Student>>(students,HttpStatus.ACCEPTED);
		
	}
	

}

	


	    @PostMapping
	    public Student createStudent(@RequestBody Student student) {
	        return studentservice.saveStudent(student);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteStudent(@PathVariable int id) {
	        return studentservice.deleteStudent(id);
	    }


	
	
	@GetMapping(value = "/student/{id}")
 public ResponseEntity<Student> getSingleStudent(@PathVariable Integer id){
	 
    Student getstud= studentservice.getSingleStudent(id);
	 
	return new ResponseEntity<Student>(getstud, HttpStatus.OK);
	}
	 
	@GetMapping(value="/batches")
	public ResponseEntity<List<Student>> getAllStudent() {
		
	List<Student> stulist=	studentservice.getAllStudent();		
		
		return new ResponseEntity<List<Student>>(stulist, HttpStatus.OK);
	}
	
	
	
	 
	 
 }

