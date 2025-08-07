package com.SBproject.app.service;


import java.util.ArrayList;
import java.util.List;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.SBproject.app.model.Batch;
import com.SBproject.app.model.Student;
import com.SBproject.app.repository.BatchRepository;

import com.SBproject.app.model.Student;

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
