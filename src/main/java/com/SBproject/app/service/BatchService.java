package com.SBproject.app.service;

import com.SBproject.app.model.Batch;

public interface BatchService {
	
	    Batch saveBatch(Batch batch);
	    String deleteBatch(int id);
	

}
