package com.gsmcorp.core.repository;

import java.util.List;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gsmcorp.core.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	/*
	 * @Query(value =
	 * "select a.availableBalance from account a where a.accountnumber = :accountnumber"
	 * , nativeQuery = true) Long getAvailableBalCustomer(@Param("accountNumber")
	 * String accountNo); //List<User> getUsersByNameSql(@Param("firstName") String
	 * firstName, @Param("lastName") String lastName);
	 * 
	 * @Query(value =
	 * "select a.ledgerBalance from account a where a.accountnumber = :accountnumber"
	 * , nativeQuery = true) Long getLedgerBalCustomer(@Param("accountNumber")
	 * String accountnumber);
	 */
	
	Account findByAccountNumber(String accountnumber);
	
	List<Account> findByCustomerId(Long customerId);

	
}
