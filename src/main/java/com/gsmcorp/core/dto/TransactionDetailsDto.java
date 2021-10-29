package com.gsmcorp.core.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class TransactionDetailsDto {
	
   
	@NotNull
	private String SourceAccountNumber;
	
	@NotNull
	private String TargetAccountNumber;
    private Date TransactionDate;
    
    @NotNull
    private Long TransactionAmount; 
    private String TransDescription;
    private String TransactionType;
    
    @NotNull
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
