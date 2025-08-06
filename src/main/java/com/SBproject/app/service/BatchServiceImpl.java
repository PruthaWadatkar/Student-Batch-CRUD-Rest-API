package com.SBproject.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.SBproject.app.model.Batch;
import com.SBproject.app.model.Student;
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

		

}
