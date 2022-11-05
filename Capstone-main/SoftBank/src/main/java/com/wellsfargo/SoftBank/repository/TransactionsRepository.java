package com.wellsfargo.SoftBank.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wellsfargo.SoftBank.model.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions,Long>{

//	void findbyDate(Date d, Sort sort);
}
