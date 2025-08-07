package com.SBproject.app.service;

import java.util.List;

import com.SBproject.app.model.Student;

public interface StudentService  {

	Student post(Student student);

	Student put(Student student, Integer bid,Integer id);

	List<Student> pagination(int page, int size);

}
