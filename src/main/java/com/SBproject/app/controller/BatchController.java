package com.SBproject.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SBproject.app.model.Batch;
import com.SBproject.app.service.BatchService;

@RestController
@RequestMapping(value = "/api/batch/")
public class BatchController {
	
	   @Autowired
	    private BatchService batchService;

	    @PostMapping
	    public Batch createBatch(@RequestBody Batch batch) {
	        return batchService.saveBatch(batch);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteBatch(@PathVariable int id) {
	        return batchService.deleteBatch(id);
	    }

}
