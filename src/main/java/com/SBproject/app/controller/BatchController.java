package com.SBproject.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SBproject.app.model.Batch;
import com.SBproject.app.model.Student;
import com.SBproject.app.service.BatchService;

@RestController
@RequestMapping(value = "/api/batch/")
public class BatchController {

	@Autowired
	BatchService service;
	
	@PostMapping("/batches")
	public ResponseEntity<Batch>  post(@RequestBody Batch batch){
		
		Batch batchs=service.post(batch);
		return new ResponseEntity<Batch>(batchs,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/batches/{bid}/{id}")
	public ResponseEntity<Batch> put(@RequestBody Batch batch,@PathVariable Integer bid,@PathVariable Integer id){
		Batch batchs=service.put(batch,bid,id);
		return new ResponseEntity<Batch>(batchs,HttpStatus.ACCEPTED);
	
	}
	
	@GetMapping("/batches/pagination")
	public ResponseEntity<java.util.List<Batch>> pagination(@RequestParam int page,@RequestParam int size ){
		java.util.List<Batch> batchs=service.pagination(page,size);
		
		return new ResponseEntity<java.util.List<Batch>>(batchs,HttpStatus.ACCEPTED);
		
	}
	
}

