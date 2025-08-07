package com.SBproject.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sname;
	private String course;
	private String address;
	private double marks;

	@ManyToMany
	private Batch batch;
	
	  @ManyToMany
	    private List<Batch> batches;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public List<Batch> getBatches() {
		return batches;
	}

	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String sname, String course, String address, double marks, List<Batch> batches) {
		super();
		this.id = id;
		this.sname = sname;
		this.course = course;
		this.address = address;
		this.marks = marks;
		this.batches = batches;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", course=" + course + ", address=" + address + ", marks="
				+ marks + ", batches=" + batches + "]";
	}
	
	
	  
	  

	
	
	
	
	
	
	
	
	
}
