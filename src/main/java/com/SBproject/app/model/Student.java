package com.SBproject.app.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String sname;
	private String course;
	private String address;
	private double marks;
	@ManyToOne
	private Batch batch;
	
	
	
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}


	public Student(int id, String sname, String course, String address, double marks, Batch batch) {
		super();
		this.id = id;
		this.sname = sname;
		this.course = course;
		this.address = address;
		this.marks = marks;
		this.batch = batch;
	}


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


	public Batch getBatch() {
		return batch;
	}


	public void setBatch(Batch batch) {
		this.batch = batch;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", course=" + course + ", address=" + address + ", marks="
				+ marks + ", batch=" + batch + "]";
	}
	
	
	
	
	
}
