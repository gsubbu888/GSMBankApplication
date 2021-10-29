package com.gsmcorp.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionDetails implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	private String sourceAccountNumber;
	private String targetAccountNumber;
    private Date transactionDate;
    private Long transactionAmount; 
    private String transDescription;
    private String transactionType;
    private Long availableBalance;
    private Long ledgerBalance;
    private int debitOrCredit;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public String getSourceAccountNumber() {
		return sourceAccountNumber;
	}
	public void setSourceAccountNumber(String sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}
	public String getTargetAccountNumber() {
		return targetAccountNumber;
	}
	public void setTargetAccountNumber(String targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Long getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransDescription() {
		return transDescription;
	}
	public void setTransDescription(String transDescription) {
		this.transDescription = transDescription;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Long getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Long availableBalance) {
		this.availableBalance = availableBalance;
	}
	public Long getLedgerBalance() {
		return ledgerBalance;
	}
	public void setLedgerBalance(Long ledgerBalance) {
		this.ledgerBalance = ledgerBalance;
	}
	public int getDebitOrCredit() {
		return debitOrCredit;
	}
	public void setDebitOrCredit(int debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}

    
}
