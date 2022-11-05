package com.wellsfargo.SoftBank.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.SoftBank.model.Login;
import com.wellsfargo.SoftBank.repository.LoginRepository;


@Service
@Transactional
public class LoginService {
	@Autowired
	private LoginRepository lsRepo;
	
	public Login save(Login ls) { 
		return lsRepo.save(ls); //Invokes save() method defined in JPA repo.	
	}
    
    public Optional<Login> getSingleLogin(long id) {
        return lsRepo.findById(id);  // defined in JPA repo
    }
    
    public void delete(long id) {
    	lsRepo.deleteById(id);  // defined in JPA repo
    }
    
    public List<Login> listAll(){
		
		return lsRepo.findAll(); //Define in JPA repo.
	}

}

	
