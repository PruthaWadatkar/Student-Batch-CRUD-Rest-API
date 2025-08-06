package com.SBproject.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SBproject.app.model.Student;
import com.SBproject.app.service.StudentService;

@RestController
@RequestMapping(value = "/api/student/")
public class StudentController {
	
	  @Autowired
	    private StudentService studentService;

	    @PostMapping
	    public Student createStudent(@RequestBody Student student) {
	        return studentService.saveStudent(student);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteStudent(@PathVariable int id) {
	        return studentService.deleteStudent(id);
	    }

}
