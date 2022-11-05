package com.wellsfargo.SoftBank.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChequeBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Checkbook_Id;
	private String AccountNumber;
	private int Priority;
	private Date IssueDate;
	private Date RequestedDate;
	
	
	public ChequeBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChequeBook(Long checkbook_Id, String accountNumber, int priority, Date issueDate, Date requestedDate) {
		super();
		Checkbook_Id = checkbook_Id;
		AccountNumber = accountNumber;
		Priority = priority;
		IssueDate = issueDate;
		RequestedDate = requestedDate;
	}
	
	public Long getCheckbook_Id() {
		return Checkbook_Id;
	}
	
	public void setCheckbook_Id(Long checkbook_Id) {
		Checkbook_Id = checkbook_Id;
	}
	
	public String getAccountNumber() {
		return AccountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	
	public int getPriority() {
		return Priority;
	}
	
	public void setPriority(int priority) {
		Priority = priority;
	}
	
	public Date getIssueDate() {
		return IssueDate;
	}
	
	public void setIssueDate(Date issueDate) {
		IssueDate = issueDate;
	}
	
	public Date getRequestedDate() {
		return RequestedDate;
	}
	
	public void setRequestedDate(Date requestedDate) {
		RequestedDate = requestedDate;
	}

	@Override
	public String toString() {
		return "Customer [Checkbook_Id=" + Checkbook_Id + ", AccountNumber=" + AccountNumber + ", Priority=" + Priority
				+ ", IssueDate=" + IssueDate + ", RequestedDate=" + RequestedDate + "]";
	}
}
