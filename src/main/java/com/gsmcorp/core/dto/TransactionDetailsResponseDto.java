package com.gsmcorp.core.dto;

import java.util.Date;

public class TransactionDetailsResponseDto {
	
	private Long AvailableBalance;
    private Long LedgerBalance;

    public Long getAvailableBalance() {
		return AvailableBalance;
	}
	public void setAvailableBalance(Long availableBalance) {
		AvailableBalance = availableBalance;
	}
	public Long getLedgerBalance() {
		return LedgerBalance;
	}
	public void setLedgerBalance(Long ledgerBalance) {
		LedgerBalance = ledgerBalance;
	}
	
	private String SourceAccountNumber;
	private String TargetAccountNumber;
    private Date TransactionDate;
    private Long TransactionAmount; 
    private String TransDescription;
    private String TransactionType;
    private int DebitOrCredit;
    
	
	public String getSourceAccountNumber() {
		return SourceAccountNumber;
	}
	public void setSourceAccountNumber(String sourceAccountNumber) {
		SourceAccountNumber = sourceAccountNumber;
	}
	public String getTargetAccountNumber() {
		return TargetAccountNumber;
	}
	public void setTargetAccountNumber(String targetAccountNumber) {
		TargetAccountNumber = targetAccountNumber;
	}
	public Date getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}
	public Long getTransactionAmount() {
		return TransactionAmount;
	}
	public void setTransactionAmount(Long transactionAmount) {
		TransactionAmount = transactionAmount;
	}
	public String getTransDescription() {
		return TransDescription;
	}
	public void setTransDescription(String transDescription) {
		TransDescription = transDescription;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	
	public int getDebitOrCredit() {
		return DebitOrCredit;
	}
	public void setDebitOrCredit(int debitOrCredit) {
		DebitOrCredit = debitOrCredit;
	}

}
