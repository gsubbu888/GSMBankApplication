package com.gsmcorp.core.dto;

import java.util.Date;

public class AccountSummaryDto {
	
	private Long AccountSummaryId;
	private String AccountNumber;
    private Date TransactionDate;
    private Long TransactionAmount;
    private int DebitOrCredit;
    private Long PreviousBalance;
    private Long AvailableBalance;
    private Long LedgerBalance;
    private Long TrasactionId;
    private String TransactionDescription;
    
	public Long getAccountSummaryId() {
		return AccountSummaryId;
	}
	public void setAccountSummaryId(Long accountSummaryId) {
		AccountSummaryId = accountSummaryId;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
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
	public int getDebitOrCredit() {
		return DebitOrCredit;
	}
	public void setDebitOrCredit(int debitOrCredit) {
		DebitOrCredit = debitOrCredit;
	}
	public Long getPreviousBalance() {
		return PreviousBalance;
	}
	public void setPreviousBalance(Long previousBalance) {
		PreviousBalance = previousBalance;
	}
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
	public Long getTrasactionId() {
		return TrasactionId;
	}
	public void setTrasactionId(Long trasactionId) {
		TrasactionId = trasactionId;
	}
	public String getTransactionDescription() {
		return TransactionDescription;
	}
	public void setTransactionDescription(String transactionDescription) {
		TransactionDescription = transactionDescription;
	}

}
