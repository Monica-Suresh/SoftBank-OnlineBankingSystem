package com.wellsfargo.SoftBank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long accTypeID; 
	private String accType;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(long accTypeID, String accType) {
		super();
		this.accTypeID = accTypeID;
		this.accType = accType;
	}
	
	public long getAccTypeID() {
		return accTypeID;
	}
	
	public void setAccTypeID(long accTypeID) {
		this.accTypeID = accTypeID;
	}
	
	public String getAccType() {
		return accType;
	}
	
	public void setAccType(String accType) {
		this.accType = accType;
	}
}
