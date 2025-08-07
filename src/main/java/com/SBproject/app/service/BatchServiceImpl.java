package com.SBproject.app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.SBproject.app.model.Batch;
import com.SBproject.app.model.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SBproject.app.model.Batch;

import com.SBproject.app.repository.BatchRepository;

@Service
public class BatchServiceImpl implements BatchService {

	 @Autowired
	    private BatchRepository batchRepository;

	    @Override
	    public Batch saveBatch(Batch batch) {
	        return batchRepository.save(batch);
	    }

	    @Override
	    public String deleteBatch(int id) {
	        if (batchRepository.existsById(id)) {
	            batchRepository.deleteById(id);
	            return "Batch deleted with ID: " + id;
	        } else {
	            return "Batch not found with ID: " + id;
	        }
	    }

		

	@Autowired
	private BatchRepository batchrepo;

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
