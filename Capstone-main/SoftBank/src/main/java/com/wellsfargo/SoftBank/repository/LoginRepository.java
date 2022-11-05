package com.wellsfargo.SoftBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.SoftBank.model.Login;

public interface LoginRepository extends JpaRepository<Login , Long> {
	
}