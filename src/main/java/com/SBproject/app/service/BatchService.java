package com.SBproject.app.service;

import java.util.List;

import com.SBproject.app.model.Batch;

public interface BatchService {

	Batch getbatchdetails(Batch batch);

	List<Batch> getAllBatchDeatails();

}
