package com.SBproject.app.service;

import java.util.List;


import com.SBproject.app.model.Student;

public interface StudentService  {
	
//	 Student saveStudent(Student student);
	 String deleteStudent(int id);

	Student getSingleStudent(Integer id);

	java.util.List<Student> getAllStudent();

	Student post(Student student);

	Student put(Student student, Integer bid,Integer id);

	List<Student> pagination(int page, int size);

}
