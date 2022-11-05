package com.wellsfargo.SoftBank.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.wellsfargo.SoftBank.model.Login;
import com.wellsfargo.SoftBank.service.LoginService;

@RestController
//@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(value = "/api")
public class LoginRestController {
	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public List<Login> getAllProducts() {
		return loginService.listAll();   
	}

	@GetMapping("/login/{id}")
	public ResponseEntity<Login> getProductById(@PathVariable(value = "id") Long lId)
			throws ResourceNotFoundException {
		Login login = loginService.getSingleLogin(lId) 
				.orElseThrow(() -> new ResourceNotFoundException("login not found for this id :: " + lId));
		return ResponseEntity.ok().body(login);
	}

	@PostMapping("/login")
	public ResponseEntity<Login> saveProduct(@Validated @RequestBody Login login) {

		Login u=loginService.save(login);
		return ResponseEntity.ok(u);

	}

	// Feature : Change Pin or Update Pin Function
	@PutMapping("/login/{id}")
	public ResponseEntity<Login> updateProduct(@PathVariable(value = "id") Long uId,
			@Validated @RequestBody Login u) throws ResourceNotFoundException {

		Login login = loginService.getSingleLogin(uId)
				.orElseThrow(() -> new ResourceNotFoundException("login not found for this id :: " + uId));
		
		login.setAtm_pin(u.getAtm_pin());

		final Login updatedProduct = loginService.save(login);
		System.out.println(updatedProduct);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/login/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long uId)
			throws ResourceNotFoundException{
		loginService.getSingleLogin(uId)
		.orElseThrow(() -> new ResourceNotFoundException("login not found for this id :: " + uId));
		loginService.delete(uId);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}


