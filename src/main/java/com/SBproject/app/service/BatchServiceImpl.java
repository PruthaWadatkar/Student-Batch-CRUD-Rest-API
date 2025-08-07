package com.SBproject.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SBproject.app.model.Batch;
import com.SBproject.app.repository.BatchRepository;

@Service
public class BatchServiceImpl implements BatchService {
	
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
