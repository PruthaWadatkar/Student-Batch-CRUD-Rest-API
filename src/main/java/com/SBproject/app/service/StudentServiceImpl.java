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
	    private StudentRepository studentRepository;

	    @Autowired
	    private BatchRepository batchRepository;

	    @Override
	    public Student saveStudent(Student student) {
	        List<Batch> existingBatches = new ArrayList<>();

	        if (student.getBatches() != null) {
	            for (Batch b : student.getBatches()) {
	                Batch batch = batchRepository.findById(b.getBid())
	                        .orElseThrow(() -> new RuntimeException("Batch not found with ID: " + b.getBid()));
	                existingBatches.add(batch);
	            }
	        }

	        student.setBatches(existingBatches);
	        return studentRepository.save(student);
	    }

	    @Override
	    public String deleteStudent(int id) {
	        if (studentRepository.existsById(id)) {
	            studentRepository.deleteById(id);
	            return "Student deleted with ID: " + id;
	        } else {
	            return "Student not found with ID: " + id;
	        }
	    }

	    // Optional method
	    public Student addStudentToExistingBatch(Student student, List<Integer> batchIds) {
	        List<Batch> existingBatches = new ArrayList<>();
	        for (Integer bid : batchIds) {
	            Batch batch = batchRepository.findById(bid)
	                    .orElseThrow(() -> new RuntimeException("Batch not found with id: " + bid));
	            existingBatches.add(batch);
	        }
	        student.setBatches(existingBatches);
	        return studentRepository.save(student);
	    }
	    
	    

	
	
	@Override
	public Student getSingleStudent(Student st) {
		Optional<Student> optional = studentRepository.findById(st.getId());
		if(optional.isPresent()) {
			
			Student student = optional.get();
			
			return student;
		}
		
		
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> all = studentRepository.findAll();
		return all;
	}

	
	
	@Override
	public Student post(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Student put(Student student, Integer bid,Integer id) {
		// TODO Auto-generated method stub
		
		Student students=studentRepository.findById(bid).get();
		//Assigning Batch to Student
		
		Batch batchs=repository2.findById(id).get();
		
		List<Batch> batchlist=students.getBatch();
		
		batchlist.add(batchs);
		students.setAddress(student.getAddress());
		students.setCourse(student.getCourse());
		students.setMarks(student.getMarks());
		students.setSname(student.getSname());
		students.setBatch(batchlist);
		return studentRepository.save(students);
		
		
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
		List<Student> list=studentRepository.findAll(request).getContent();
 		return list;
	}

}
