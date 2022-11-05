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
import com.wellsfargo.SoftBank.model.FundTransfer;
import com.wellsfargo.SoftBank.service.FundTransferService;

@RestController
@RequestMapping(value="/api")
public class FundTransferRestController {

	@Autowired
	private FundTransferService fService;

	/* Request -- Client --> Controller --> Service --> Repository --> Database */
	/* Response -- Repository --> Service --> Client */

	@PostMapping("/fund")
	public ResponseEntity<FundTransfer> saveProduct(@Validated @RequestBody FundTransfer c) {

		FundTransfer fund=fService.save(c);
		return ResponseEntity.ok(fund);

	}
	@PutMapping("/fund/{id}")
	public FundTransfer registerCustomer(@PathVariable(value = "id") Long tId,
			@Validated @RequestBody FundTransfer f1) throws ResourceNotFoundException {

		FundTransfer ft = fService.getSingleEntry(tId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + tId));	


		ft.setTransactonId(f1.getTransactonId());
		ft.setTransferAmount(f1.getTransferAmount());
		ft.setDestAccNumber(f1.getDestAccNumber());
		ft.setDestAccTypeId(f1.getDestAccTypeId());
		ft.setSourceAccNumber(f1.getSourceAccNumber());

		ft=fService.save(ft);
		return ft;

	}

	@GetMapping("/allfund")
	public List<FundTransfer> listAll(){
		return fService.listAll();
	}

	@GetMapping("/fund/{id}")
	public ResponseEntity<FundTransfer> getProductById(@PathVariable(value = "id") Long uId)
			throws ResourceNotFoundException {
		FundTransfer Entry = fService.getSingleEntry(uId) 
				.orElseThrow(() -> new ResourceNotFoundException("Entry not found for this id :: " + uId));
		return ResponseEntity.ok().body(Entry);
	}

	@DeleteMapping("/fund/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long uId)
			throws ResourceNotFoundException{
		fService.getSingleEntry(uId)
		.orElseThrow(() -> new ResourceNotFoundException("Entry not found for this id :: " + uId));
		fService.delete(uId);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}


