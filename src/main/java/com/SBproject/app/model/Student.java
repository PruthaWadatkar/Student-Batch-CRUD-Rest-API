package com.SBproject.app.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String sname;
	private String course;
	private String address;
	private double marks;

	//@JoinColumn(name = "bid")
	@JsonIgnore
	@ManyToMany
	private List<Batch> batch=new ArrayList<>();
	
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Student(Integer id, String sname, String course, String address, double marks, List<Batch> batch) {
		super();
		this.id = id;
		this.sname = sname;
		this.course = course;
		this.address = address;
		this.marks = marks;
		this.batch = batch;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public List<Batch> getBatch() {
		return batch;
	}
	public void setBatch(List<Batch> batch) {
		this.batch = batch;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", course=" + course + ", address=" + address + ", marks="
				+ marks + ", batch=" + batch + "]";
	}

	
}
		
	
	
