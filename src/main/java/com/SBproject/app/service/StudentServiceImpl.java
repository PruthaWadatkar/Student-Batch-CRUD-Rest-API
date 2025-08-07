package com.SBproject.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.SBproject.app.model.Batch;
import com.SBproject.app.model.Student;
import com.SBproject.app.repository.BatchRepository;
import com.SBproject.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	StudentRepository  repository;
	
	@Autowired
	 BatchRepository repository2;
	
	@Override
	public Student post(Student student) {
		// TODO Auto-generated method stub
		return repository.save(student);
	}

	@Override
	public Student put(Student student, Integer bid,Integer id) {
		// TODO Auto-generated method stub
		
		Student students=repository.findById(bid).get();
		//Assigning Batch to Student
		
		Batch batchs=repository2.findById(id).get();
		
		List<Batch> batchlist=students.getBatch();
		
		batchlist.add(batchs);
		students.setAddress(student.getAddress());
		students.setCourse(student.getCourse());
		students.setMarks(student.getMarks());
		students.setSname(student.getSname());
		students.setBatch(batchlist);
		return repository.save(students);
		
		
		/*
		 * if(students.getBatch().getBid()==bid) {
		 * students.setAddress(student.getAddress());
		 * students.setBatch(student.getBatch());
		 * students.setCourse(student.getCourse());
		 * students.setMarks(student.getMarks()); students.setSname(student.getSname());
		 * 
		 * repository.save(students); }
		 */
		
	}

	@Override
	public List<Student> pagination(int page, int size) {
		// TODO Auto-generated method stub
		
		PageRequest request=PageRequest.of(page, size);
		List<Student> list=repository.findAll(request).getContent();
 		return list;
	}

}
