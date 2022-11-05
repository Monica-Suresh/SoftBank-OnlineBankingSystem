package com.wellsfargo.SoftBank.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.SoftBank.model.Users;
import com.wellsfargo.SoftBank.repository.UserRepository;

@Service
@Transactional
public class UserRestService {

	@Autowired
	private UserRepository userRepo;
	
	public Users save(Users p) { 
		//User defined method in service class.
		
		return userRepo.save(p); //Invokes save() method defined in JPA repo.	
	}
    
    public Optional<Users> getSingleUser(long id) {
        return userRepo.findById(id);  // defined in JPA repo
    }
    
    public void delete(long id) {
    	userRepo.deleteById(id);  // defined in JPA repo
    }
    
    public List<Users> listAll(){
		
		return userRepo.findAll(); //Define in JPA repo.
	}
}
