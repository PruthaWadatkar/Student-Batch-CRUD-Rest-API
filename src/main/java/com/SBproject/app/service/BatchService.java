package com.SBproject.app.service;

import java.util.List;

import com.SBproject.app.model.Batch;


public interface BatchService {

	Batch post(Batch batch);

	Batch put(Batch batch, Integer bid, Integer id);

	List<Batch> pagination(int page, int size);

}
