package com.SBproject.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.SBproject.app.model.Student;
import com.SBproject.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository sturepo;
	
	
	@Override
	public Student getSingleStudent(Student st) {
		Optional<Student> optional = sturepo.findById(st.getId());
		if(optional.isPresent()) {
			
			Student student = optional.get();
			
			return student;
		}
		
		
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> all = sturepo.findAll();
		return all;
	}

}
