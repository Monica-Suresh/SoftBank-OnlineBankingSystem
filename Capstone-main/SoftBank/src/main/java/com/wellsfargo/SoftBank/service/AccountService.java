package com.wellsfargo.SoftBank.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.SoftBank.model.Account;
import com.wellsfargo.SoftBank.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository accRepo;
	
	public Account save(Account p) { 
		
		return accRepo.save(p);
	}
    
    public Optional<Account> getSingleAccount(long id) {
        return accRepo.findById(id);  
    }
    
    public void delete(long id) {
    	accRepo.deleteById(id);
    }
    
    public List<Account> listAll(){
		
		return accRepo.findAll(); 
	}
}

