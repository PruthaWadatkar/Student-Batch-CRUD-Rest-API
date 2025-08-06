package com.SBproject.app.service;

import com.SBproject.app.model.Student;

public interface StudentService  {
	
	 Student saveStudent(Student student);
	 String deleteStudent(int id);

}
