package com.wellsfargo.SoftBank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fundTransfer")
public class FundTransfer {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long transactonId;
	private long sourceAccNumber;
	private long destAccNumber;
	private long destAccTypeId;
	private long transferAmount;
	public FundTransfer() {
		// TODO Auto-generated constructor stub
	}
	public FundTransfer(long transactonId, long sourceAccNumber, long destAccNumber, long destAccTypeId,
			long transferAmount) {
		super();
		this.transactonId = transactonId;
		this.sourceAccNumber = sourceAccNumber;
		this.destAccNumber = destAccNumber;
		this.destAccTypeId = destAccTypeId;
		this.transferAmount = transferAmount;
	}
	public long getTransactonId() {
		return transactonId;
	}
	public void setTransactonId(long transactonId) {
		this.transactonId = transactonId;
	}
	public long getSourceAccNumber() {
		return sourceAccNumber;
	}
	public void setSourceAccNumber(long sourceAccNumber) {
		this.sourceAccNumber = sourceAccNumber;
	}
	public long getDestAccNumber() {
		return destAccNumber;
	}
	public void setDestAccNumber(long destAccNumber) {
		this.destAccNumber = destAccNumber;
	}
	public long getDestAccTypeId() {
		return destAccTypeId;
	}
	public void setDestAccTypeId(long destAccTypeId) {
		this.destAccTypeId = destAccTypeId;
	}
	public long getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(long transferAmount) {
		this.transferAmount = transferAmount;
	}
	

}
