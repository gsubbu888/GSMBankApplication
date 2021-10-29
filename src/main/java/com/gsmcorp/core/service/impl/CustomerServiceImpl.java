package com.gsmcorp.core.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsmcorp.core.dto.CustomerDto;
import com.gsmcorp.core.dto.CustomerResponseDto;
import com.gsmcorp.core.entity.Account;
import com.gsmcorp.core.entity.Customer;
import com.gsmcorp.core.repository.AccountRepository;
import com.gsmcorp.core.repository.CustomerRepository;
import com.gsmcorp.core.service.AccountService;
import com.gsmcorp.core.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService, AccountService {

	@Autowired
	CustomerRepository custRepository;

	@Autowired
	AccountRepository accRepository;

	@Override
	public String addCustomer(CustomerDto customerDto) {
		long age = 0;
		try {
			String birth = customerDto.getDateOfBirth();
			Date date1;
			// String sDate1="31/12/1998";
			date1 = new SimpleDateFormat("dd-MM-yyyy").parse(birth);
			System.out.println(birth + "\t" + date1);
			Date date2 = new Date();
			long time_difference = date2.getTime() - date1.getTime();
			age = (time_difference / (1000l * 60 * 60 * 24 * 365));
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (age > Long.valueOf(18)) {

			Customer customer = new Customer();
			BeanUtils.copyProperties(customerDto, customer);

			Random ran = new Random();
			int randomNum = ran.nextInt(10000);

			custRepository.save(customer);

			Account account = new Account();
			account.setAccountNumber("00000" + randomNum);
			account.setAccountOpeningDate(new Date());
			account.setAccountStatus(customerDto.getAccountStatus());
			account.setAccountOpeningDate(customerDto.getAccountOpeningDate());
			account.setOpeningBalance(customerDto.getOpeningBalance());
			account.setAccountType(customerDto.getAccountType());
			account.setCustomerId(customer.getCustomerId());
			account.setAvailableBalance(customerDto.getOpeningBalance());
			account.setLedgerBalance(customerDto.getOpeningBalance());
			addAccount(account);

			return account.getAccountNumber();
		} else {
			return "Invalid";
		}
	}

	@Override
	public String addAccount(Account account) {
		// TODO Auto-generated method stub
		accRepository.save(account);
		return null;
	}

	@Override
	public CustomerResponseDto getCustomerbyPhoneNo(String phoneNumber) {
		Customer customer=new Customer();
		CustomerResponseDto customerDto=new CustomerResponseDto();
		customer=custRepository.findByPhoneNo(phoneNumber);
		List<Account> account=accRepository.findByCustomerId(customer.getCustomerId());
		
		customerDto.setCustomerId(customer.getCustomerId());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setCity(customer.getCity());
		customerDto.setDateOfBirth(customer.getDateOfBirth());
		customerDto.setMiddleName(customer.getMiddleName());
		customerDto.setOccupation(customer.getOccupation());
		customerDto.setPhoneNo(customer.getPhoneNo());
		customerDto.setAccountNumber(account.get(0).getAccountNumber());
		customerDto.setAccountStatus(account.get(0).getAccountStatus());
		customerDto.setAccountOpeningDate(account.get(0).getAccountOpeningDate());
		customerDto.setAvailableBalance(account.get(0).getAvailableBalance());
		customerDto.setLedgerBalance(account.get(0).getLedgerBalance());
		customerDto.setOpeningBalance(account.get(0).getOpeningBalance());
		customerDto.setAccountType(account.get(0).getAccountType());
		
		
		
		// TODO Auto-generated method stub
		return customerDto;
	}
	

}
