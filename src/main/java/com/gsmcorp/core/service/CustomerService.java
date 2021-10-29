package com.gsmcorp.core.service;

import com.gsmcorp.core.dto.CustomerResponseDto;
import com.gsmcorp.core.dto.CustomerDto;

public interface CustomerService {
	
	public String addCustomer(CustomerDto customerDto);
	
	public CustomerResponseDto getCustomerbyPhoneNo(String phoneNumber);

}
