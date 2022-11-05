package com.wellsfargo.SoftBank.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.SoftBank.model.FundTransfer;
import com.wellsfargo.SoftBank.repository.FundTransferRepository;

@Service
@Transactional
public class FundTransferService {

	@Autowired
	private FundTransferRepository fundRepo;
	
	public FundTransfer save(FundTransfer p) { 
		
		return fundRepo.save(p);
	}
    
    public Optional<FundTransfer> getSingleEntry(long id) {
        return fundRepo.findById(id);  
    }
    
    public void delete(long id) {
    	fundRepo.deleteById(id);
    }
    
    public List<FundTransfer> listAll(){
		
		return fundRepo.findAll(); 
	}
}

