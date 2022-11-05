package com.wellsfargo.SoftBank.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.SoftBank.model.ChequeBook;

import com.wellsfargo.SoftBank.repository.ChequeBookRepository;

@Service
@Transactional
public class ChequeBookService {
	
	@Autowired
	private ChequeBookRepository crepo;
	
	public ChequeBook registerCheque(ChequeBook cb) {
		return crepo.save(cb);
	}
	
	public List<ChequeBook> getAllCheque(){
		return crepo.findAll();
	}
	
    public Optional<ChequeBook> getSingleEntry(long id) {
        return crepo.findById(id); 
    }
    
    public void delete(long id) {
    	crepo.deleteById(id);
    }

}
