package com.wellsfargo.SoftBank.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.SoftBank.model.Transactions;
import com.wellsfargo.SoftBank.repository.TransactionsRepository;
import com.wellsfargo.SoftBank.service.TransactionsService;

@RestController
@RequestMapping(value="/api")

public class TransactionsController {
	@Autowired
	private TransactionsService tservice;
	
	@Autowired
	private TransactionsRepository trepo;
	

	@PostMapping("/transactions")
	public Transactions transactcust(@Validated @RequestBody Transactions trans) {
		
		Transactions t=new Transactions();
		t.setAccount_number(trans.getAccount_number());
		t.setAccountTypeID(trans.getAccountTypeID());
		t.setTransactionType(trans.getTransactionType());
		t.setTransactionDate(trans.getTransactionDate());
		t.setAmount(trans.getAmount());
		
		t=tservice.transcatcust(t);
		
		return trans;
		
	}
	
	@GetMapping("/alltransactions")
	public List<Transactions> getAllTransactions(){
		return tservice.getAllTransactions();
		
	}

}
