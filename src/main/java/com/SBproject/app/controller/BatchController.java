package com.SBproject.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SBproject.app.model.Batch;
import com.SBproject.app.service.BatchService;

@RestController
@RequestMapping(value = "/api/batch/")
public class BatchController {

	
	@Autowired
	private BatchService batchservice;
	
	
	
	@GetMapping(value="/batches/{bid}")
	public ResponseEntity<Batch>getBatchdetails(@PathVariable Batch batch){
		
	Batch getbatch=	batchservice.getbatchdetails(batch);
		
		return new ResponseEntity<Batch>(getbatch,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/batches")
	public ResponseEntity<List<Batch>> getAllBatchDetails(){
	List<Batch> batchlist =	batchservice.getAllBatchDeatails();
		return new ResponseEntity<List<Batch>>(batchlist,HttpStatus.OK);
	}
	
}
