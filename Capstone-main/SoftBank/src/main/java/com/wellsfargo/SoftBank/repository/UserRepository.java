package com.wellsfargo.SoftBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.SoftBank.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	/*
       This interface has save(),findAll(),findById(),deleteById(),count()
       etc.. inbuilt methods of jpa repository for various database operations.
       This interface will be implemented by class automatically
    */	
}
