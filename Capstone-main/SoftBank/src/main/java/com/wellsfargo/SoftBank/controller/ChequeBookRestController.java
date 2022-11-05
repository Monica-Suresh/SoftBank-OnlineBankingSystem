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
import com.wellsfargo.SoftBank.model.ChequeBook;
import com.wellsfargo.SoftBank.service.ChequeBookService;

@RestController
@RequestMapping(value="/api")
public class ChequeBookRestController {
	
	@Autowired
	private ChequeBookService cService;
	
	/* Request -- Client --> Controller --> Service --> Repository --> Database */
	/* Response -- Repository --> Service --> Client */
	
	// Feature : Request ChequeBook from the browser
	@PostMapping("/cheque")
	public ResponseEntity<ChequeBook> saveProduct(@Validated @RequestBody ChequeBook c) {

		ChequeBook cheque=cService.registerCheque(c);
		return ResponseEntity.ok(cheque);

	}
	@PutMapping("/cheque/{id}")
	public ChequeBook registerCustomer(@PathVariable(value = "id") Long cno,
			@Validated @RequestBody ChequeBook c_new) throws ResourceNotFoundException {
		
		ChequeBook c1 = cService.getSingleEntry(cno)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found for this id :: " + cno));
		
		c1.setCheckbook_Id(c_new.getCheckbook_Id());
		c1.setAccountNumber(c_new.getAccountNumber());
		c1.setRequestedDate(c_new.getRequestedDate());
		c1.setIssueDate(c_new.getIssueDate());
		c1.setPriority(c_new.getPriority());
		
		c1=cService.registerCheque(c1);
		return c1;
		
	}
	
	@GetMapping("/allcheque")
	public List<ChequeBook> getAllCheque(){
		return cService.getAllCheque();
	}
	
	@GetMapping("/cheque/{id}")
	public ResponseEntity<ChequeBook> getProductById(@PathVariable(value = "id") Long uId)
			throws ResourceNotFoundException {
		ChequeBook Entry = cService.getSingleEntry(uId) 
				.orElseThrow(() -> new ResourceNotFoundException("Entry not found for this id :: " + uId));
		return ResponseEntity.ok().body(Entry);
	}
	
	@DeleteMapping("/cheque/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long uId)
			throws ResourceNotFoundException{
		cService.getSingleEntry(uId)
		.orElseThrow(() -> new ResourceNotFoundException("Entry not found for this id :: " + uId));
		cService.delete(uId);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}


