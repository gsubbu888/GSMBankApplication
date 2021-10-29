package com.gsmcorp.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gsmcorp.core.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Customer findByPhoneNo(String phoneNo);

}
