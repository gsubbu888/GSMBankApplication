package com.gsmcorp.core.service.impl;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsmcorp.core.dto.TransactionDetailsDto;
import com.gsmcorp.core.dto.TransactionDetailsResponseDto;
import com.gsmcorp.core.entity.Account;
import com.gsmcorp.core.entity.TransactionDetails;
import com.gsmcorp.core.repository.AccountRepository;
import com.gsmcorp.core.repository.TransactionDetailsRepository;
import com.gsmcorp.core.service.TransactionDetailsService;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService {

	@Autowired
	TransactionDetailsRepository transactionDetailsRepository;

	@Autowired
	AccountRepository accountRepository;

	@Override
	public TransactionDetailsResponseDto addTransactionDetails(TransactionDetailsDto trans) {
		TransactionDetailsResponseDto resDto = new TransactionDetailsResponseDto();
		TransactionDetails sourceAccTransactionDetails = new TransactionDetails();
		TransactionDetails targetAccTransactionDetails = new TransactionDetails();

		Account sourceAcc = accountRepository.findByAccountNumber(trans.getSourceAccountNumber());
		Account targetAcc = accountRepository.findByAccountNumber(trans.getTargetAccountNumber());
		if (sourceAcc != null | targetAcc != null) {
			System.out.println(sourceAcc.getAvailableBalance());

			sourceAccTransactionDetails.setSourceAccountNumber(trans.getSourceAccountNumber());
			sourceAccTransactionDetails.setTargetAccountNumber(trans.getTargetAccountNumber());
			sourceAccTransactionDetails.setTransactionAmount(trans.getTransactionAmount());
			sourceAccTransactionDetails.setTransactionDate(new Date());
			sourceAccTransactionDetails.setTransactionType(trans.getTransactionType());
			sourceAccTransactionDetails.setTransDescription(trans.getTransDescription());
			sourceAccTransactionDetails.setDebitOrCredit(0);
			sourceAccTransactionDetails
					.setAvailableBalance(sourceAcc.getAvailableBalance() - trans.getTransactionAmount());
			sourceAccTransactionDetails.setLedgerBalance(sourceAcc.getLedgerBalance() - trans.getTransactionAmount());

			System.out.println(sourceAccTransactionDetails.getAvailableBalance());

			targetAccTransactionDetails.setSourceAccountNumber(trans.getSourceAccountNumber());
			targetAccTransactionDetails.setTargetAccountNumber(trans.getTargetAccountNumber());
			targetAccTransactionDetails.setTransactionAmount(trans.getTransactionAmount());
			targetAccTransactionDetails.setTransactionDate(new Date());
			targetAccTransactionDetails.setTransactionType(trans.getTransactionType());
			targetAccTransactionDetails.setTransDescription(trans.getTransDescription());
			targetAccTransactionDetails.setDebitOrCredit(1);
			targetAccTransactionDetails
					.setAvailableBalance(targetAcc.getAvailableBalance() + trans.getTransactionAmount());
			targetAccTransactionDetails.setLedgerBalance(targetAcc.getLedgerBalance() + trans.getTransactionAmount());

			transactionDetailsRepository.save(sourceAccTransactionDetails);
			transactionDetailsRepository.save(targetAccTransactionDetails);

			System.out.println("sourceAccTransactionDetails::" + sourceAccTransactionDetails.getAvailableBalance());
			System.out.println("targetAccTransactionDetails::" + targetAccTransactionDetails.getAvailableBalance());

			resDto.setAvailableBalance(sourceAccTransactionDetails.getAvailableBalance());
			resDto.setLedgerBalance(sourceAccTransactionDetails.getLedgerBalance());
			resDto.setTransactionAmount(sourceAccTransactionDetails.getTransactionAmount());
			resDto.setTransactionDate(sourceAccTransactionDetails.getTransactionDate());
			resDto.setTransDescription(sourceAccTransactionDetails.getTransDescription());
			resDto.setSourceAccountNumber(sourceAccTransactionDetails.getSourceAccountNumber());
			resDto.setTargetAccountNumber(sourceAccTransactionDetails.getTargetAccountNumber());
			resDto.setTransactionType(sourceAccTransactionDetails.getTransactionType());

			sourceAcc.setAvailableBalance(sourceAcc.getAvailableBalance() - trans.getTransactionAmount());
			sourceAcc.setLedgerBalance(sourceAcc.getLedgerBalance() - trans.getTransactionAmount());
			accountRepository.save(sourceAcc);

			targetAcc.setAvailableBalance(targetAcc.getAvailableBalance() + trans.getTransactionAmount());
			targetAcc.setLedgerBalance(targetAcc.getLedgerBalance() + trans.getTransactionAmount());
			accountRepository.save(targetAcc);

			return resDto;
		} else {
			return null;
		}
	}

	@Override
	public List<TransactionDetailsResponseDto> getStatementForMonth(String accountNumber, int month, int year) {

		System.out.println("getStatementForMonth Impl");
		List<TransactionDetails> transDetails = new ArrayList<TransactionDetails>();
		System.out.println("transDetails.size::" + transDetails.size());
		List<TransactionDetailsResponseDto> transDtos = new ArrayList<TransactionDetailsResponseDto>();

		LocalDate startLocalDate = LocalDate.of(year, month, 1);
		LocalDate endLocalDate = startLocalDate.with(TemporalAdjusters.lastDayOfMonth());
		ZoneId defaultZoneId = ZoneId.systemDefault();

		Date startDate = Date.from(startLocalDate.atStartOfDay(defaultZoneId).toInstant());
		Date endDate = Date.from(endLocalDate.atStartOfDay(defaultZoneId).toInstant());

		System.out.println("startLocalDate" + startLocalDate);
		System.out.println("endLocalDate" + endLocalDate);

		System.out.println("startDate" + startDate);
		System.out.println("endDate" + endDate);

		transDetails = transactionDetailsRepository.getStatementForGivenMonth(accountNumber, startDate, endDate);
		System.out.println("transDetails.size::" + transDetails.size());
		for (TransactionDetails trans : transDetails) {
			TransactionDetailsResponseDto resDto = new TransactionDetailsResponseDto();

			resDto.setAvailableBalance(trans.getAvailableBalance());
			resDto.setLedgerBalance(trans.getLedgerBalance());
			resDto.setTransactionAmount(trans.getTransactionAmount());
			resDto.setTransactionDate(trans.getTransactionDate());
			resDto.setTransDescription(trans.getTransDescription());
			resDto.setSourceAccountNumber(trans.getSourceAccountNumber());
			resDto.setTargetAccountNumber(trans.getTargetAccountNumber());
			resDto.setTransactionType(trans.getTransactionType());
			transDtos.add(resDto);
		}
		return transDtos;

	}

}
