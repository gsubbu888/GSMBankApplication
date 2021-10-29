package com.gsmcorp.core.repository;

import java.util.List;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.gsmcorp.core.entity.TransactionDetails;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long>{
	
@Query("from TransactionDetails where transactionDate between :startDate and :endDate and sourceAccountNumber=:accountNumber Or targetAccountNumber=:accountNumber")
	List<TransactionDetails> getStatementForGivenMonth(@Param("accountNumber") String accountNumber,@Param("startDate") Date startDate,@Param("endDate") Date endDate);
	
	
	
	

}
