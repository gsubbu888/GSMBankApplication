package com.gsmcorp.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountID;
	private String accountNumber;
	private Long customerId;
	private Long openingBalance;
	private Long availableBalance;
	private Long ledgerBalance;
	private Date accountOpeningDate;
	private String accountType;
	private String accountStatus;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getAccountID() {
		return accountID;
	}
	public void setAccountID(Long accountID) {
		this.accountID = accountID;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public Long getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(Long openingBalance) {
		this.openingBalance = openingBalance;
	}
	public Date getAccountOpeningDate() {
		return accountOpeningDate;
	}
	public void setAccountOpeningDate(Date accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
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
	

}
