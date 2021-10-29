package com.gsmcorp.core.service;

import com.gsmcorp.core.dto.TransactionDetailsDto;
import com.gsmcorp.core.dto.StatementDto;
import com.gsmcorp.core.dto.TransactionDetailsResponseDto;
import java.util.List;

public interface TransactionDetailsService {
	
	public TransactionDetailsResponseDto addTransactionDetails(TransactionDetailsDto trans);
	
	public List<TransactionDetailsResponseDto> getStatementForMonth(String accountNumber,int month,int year);

}
