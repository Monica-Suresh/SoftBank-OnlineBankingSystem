package com.wellsfargo.SoftBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.SoftBank.model.Account;

public interface AccountRepository extends JpaRepository <Account, Long> {

}
