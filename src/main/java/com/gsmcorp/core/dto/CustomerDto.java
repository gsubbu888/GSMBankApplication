package com.gsmcorp.core.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class CustomerDto {
	

	@NotNull
	private String firstName;
	private String middleName;
	
	@NotNull
	private String lastName;
	@NotNull
	private String city;
	@NotNull
	private String phoneNo;
	
	private String occupation;
	
	@NotNull
	private String dateOfBirth;
	
	@NotNull
	private Long openingBalance;
	
	@NotNull
    private Date accountOpeningDate;
    
    @NotNull
    private String accountType;
    @NotNull
    private String accountStatus;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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


}
