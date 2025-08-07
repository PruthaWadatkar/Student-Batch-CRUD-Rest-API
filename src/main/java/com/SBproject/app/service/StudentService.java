package com.SBproject.app.service;

import com.SBproject.app.model.Student;

public interface StudentService  {

	Student getSingleStudent(Student st);

	java.util.List<Student> getAllStudent();

}
