package com.SBproject.app.service;


import java.util.List;


import com.SBproject.app.model.Batch;

public interface BatchService {
	
	    Batch saveBatch(Batch batch);
	    String deleteBatch(int id);
	

	Batch getbatchdetails(Batch batch);

	List<Batch> getAllBatchDeatails();

}
