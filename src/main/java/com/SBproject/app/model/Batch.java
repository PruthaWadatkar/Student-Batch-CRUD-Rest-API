package com.SBproject.app.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Batch {
	
@Id
	private Integer bid;
	private String bname;
	private String baddress;
	private double fees;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Student stu;
	
	public Batch() {
		// TODO Auto-generated constructor stub
	}

	public Batch(int bid, String bname, String baddress, double fees, Student stu) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.baddress = baddress;
		this.fees = fees;
		this.stu = stu;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBaddress() {
		return baddress;
	}

	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", bname=" + bname + ", baddress=" + baddress + ", fees=" + fees + ", stu=" + stu
				+ "]";
	}
	
	
	
	
	
}
