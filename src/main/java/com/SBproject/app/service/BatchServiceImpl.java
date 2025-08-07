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
	private BatchRepository batchrepo;
  @Autowired
  private StudentRepository studentrepo;
	
	@Override
	public Batch post(Batch batch) {
		// TODO Auto-generated method stub
		return batchrepo.save(batch);
	}

	@Override
	public Batch put(Batch batch, Integer bid,Integer id) {
		// TODO Auto-generated method stub
		
		
		Batch batchs=batchrepo.findById(bid).get();
		Student student=studentrepo.findById(id).get();
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
		
		return batchrepo.save(batchs);
		
		
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
		List<Batch> batch=batchrepo.findAll(request).getContent();
		return batch;
		
	}

	    @Override
	    public Batch saveBatch(Batch batch) {
	        return batchrepo.save(batch);
	    }

	    @Override
	    public String deleteBatch(int id) {
	        if (batchrepo.existsById(id)) {
	            batchrepo.deleteById(id);
	            return "Batch deleted with ID: " + id;
	        } else {
	            return "Batch not found with ID: " + id;
	        }
	    }

		



	@Override
	public Batch getbatchdetails(Batch batch) {
		
	Optional<Batch> getdetails=	batchrepo.findById(batch.getBid());
		if(getdetails.isPresent()) {
			
			Batch bat = getdetails.get();
			return batch;
		}
		
		return null;
	}

	@Override
	public List<Batch> getAllBatchDeatails() {
		
		List<Batch> getall = batchrepo.findAll();
		return getall;
	}


}
