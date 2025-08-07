package com.SBproject.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.SBproject.app.model.Batch;
import com.SBproject.app.model.Student;
import com.SBproject.app.repository.BatchRepository;
import com.SBproject.app.repository.StudentRepository;

@Service
public class BatchServiceImpl implements BatchService {

	
	@Autowired
	BatchRepository repository;
	
	@Autowired
	StudentRepository repository1;
	
	@Override
	public Batch post(Batch batch) {
		// TODO Auto-generated method stub
		return repository.save(batch);
	}

	@Override
	public Batch put(Batch batch, Integer bid,Integer id) {
		// TODO Auto-generated method stub
		
		
		Batch batchs=repository.findById(bid).get();
		Student student=repository1.findById(id).get();
		//Assigning Batch to student
		
		
		/*Assigning Batch to Student
		 * List<Batch> batchlist=student.getBatch();
		 * batchlist.add(batchs);
		 * student.setBatch(batchlist);
		 */
		//Assigning Student to Batch
		
		List<Student> studnetlist= batchs.getStu();
		studnetlist.add(student);
		
		batchs.setBname(batch.getBname());
		batchs.setBaddress(batch.getBaddress());
		batchs.setFees(batchs.getFees());
	
		batchs.setStu(studnetlist);
		
		return repository.save(batchs);
		
		
		/*if(batchs.getBid()==bid) {
			batchs.setBid(batch.getBid());
			batchs.setBname(batch.getBname());
			batchs.setBaddress(batch.getBaddress());
			batchs.setFees(batch.getFees());*/
			
			/*
			 * List<Student> list=batch.getStu(); batchs.setStu(list);
			 */
			/*batchs.setStu(batch.getStu());*/
		
		
			
			/*
			 * } return null;
			 */
		
	}

	@Override
	public List<Batch> pagination(int page, int size) {
		// TODO Auto-generated method stub
		
		PageRequest request= PageRequest.of(page, size);
		List<Batch> batch=repository.findAll(request).getContent();
		return batch;
		
	}

}
