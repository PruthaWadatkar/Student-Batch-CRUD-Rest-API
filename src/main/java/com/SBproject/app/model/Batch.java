package com.SBproject.app.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Batch {

	@Id
	private int bid;
	private String bname;
	private String baddress;
	private double fees;
	
	public Batch() {
		// TODO Auto-generated constructor stub
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

	public Batch(int bid, String bname, String baddress, double fees) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.baddress = baddress;
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", bname=" + bname + ", baddress=" + baddress + ", fees=" + fees + "]";
	}

	
	
	
	
}
