package com.gsmcorp.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gsmcorp.core.dto.TransactionDetailsDto;
import com.gsmcorp.core.dto.TransactionDetailsResponseDto;
import com.gsmcorp.core.service.TransactionDetailsService;

@RestController
@RequestMapping("/transDetails")
public class TransactionDetailsController {
	
	@Autowired
	TransactionDetailsService transService;

	@PostMapping
	public TransactionDetailsResponseDto addTransactionDetails(@Valid @RequestBody TransactionDetailsDto trans) {
		return transService.addTransactionDetails(trans);
		 
	}
	
	@GetMapping("/stmt")
	public List<TransactionDetailsResponseDto> getStatementForMonth(@RequestParam String accountNumber, @RequestParam int month,@RequestParam int year) {
		System.out.println("accountNumber"+accountNumber);
		return transService.getStatementForMonth(accountNumber,month,year);
		 
	}
	
	
}
