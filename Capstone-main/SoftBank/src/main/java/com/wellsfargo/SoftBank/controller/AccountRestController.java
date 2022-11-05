package com.wellsfargo.SoftBank.controller;

import java.util.List;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.wellsfargo.SoftBank.exception.ResourceNotFoundException;
import com.wellsfargo.SoftBank.model.Account;
import com.wellsfargo.SoftBank.service.AccountService;

@RestController
@RequestMapping(value="/api")
public class AccountRestController {
	
	@Autowired
	private AccountService aService;
	
	/* Request -- Client --> Controller --> Service --> Repository --> Database */
	/* Response -- Repository --> Service --> Client */
	
	@PostMapping("/account")
	public ResponseEntity<Account> saveProduct(@Validated @RequestBody Account c) {

		Account account=aService.save(c);
		return ResponseEntity.ok(account);

	}
	@PutMapping("/account/{id}")
	public Account registerCustomer(@PathVariable(value = "id") Long ano,
			@Validated @RequestBody Account a1) throws ResourceNotFoundException {
		
				Account acc = aService.getSingleAccount(ano)
						.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + ano));
		
		acc.setAccType(a1.getAccType());
		acc.setAccTypeID(a1.getAccTypeID());
		final Account updatedacc = aService.save(acc);
		System.out.println(updatedacc);
		return acc;
		
	}
	
	@GetMapping("/allaccount")
	public List<Account> getAllAccount(){
		return aService.listAll();
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getProductById(@PathVariable(value = "id") Long uId)
			throws ResourceNotFoundException {
		Account account = aService.getSingleAccount(uId) 
				.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + uId));
		return ResponseEntity.ok().body(account);
	}
	
	@DeleteMapping("/account/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long aId)
			throws ResourceNotFoundException{
		aService.getSingleAccount(aId)
		.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + aId));
		aService.delete(aId);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}


