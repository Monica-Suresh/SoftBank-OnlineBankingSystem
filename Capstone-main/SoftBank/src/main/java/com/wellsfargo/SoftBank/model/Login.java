package com.wellsfargo.SoftBank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	long account_number;
	int atm_pin;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(int id, long account_number, int atm_pin) {
		super();
		this.id = id;
		this.account_number = account_number;
		this.atm_pin = atm_pin;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public int getAtm_pin() {
		return atm_pin;
	}
	public void setAtm_pin(int atm_pin) {
		this.atm_pin = atm_pin;
	}
	
	@Override
	public String toString() {
		return "Login [id=" + id + ", account_number=" + account_number + ", atm_pin=" + atm_pin + "]";
	}
}
