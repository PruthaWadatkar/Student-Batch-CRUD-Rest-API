package com.SBproject.app.service;


import java.util.List;

import com.SBproject.app.model.Batch;



public interface BatchService {
	
	    Batch saveBatch(Batch batch);
	    String deleteBatch(int id);
	

	Batch getbatchdetails(Integer bid);

	List<Batch> getAllBatchDeatails();

	Batch post(Batch batch);

	Batch put(Batch batch, Integer bid, Integer id);

	List<Batch> pagination(int page, int size);

}
