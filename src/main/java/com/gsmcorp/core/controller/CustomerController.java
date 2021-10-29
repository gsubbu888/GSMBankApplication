package com.gsmcorp.core.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gsmcorp.core.dto.CustomerDto;
import com.gsmcorp.core.dto.CustomerResponseDto;
import com.gsmcorp.core.service.CustomerService;

@RestController
@RequestMapping("/customerDetails")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping
	public String addCustomer(@Valid @RequestBody CustomerDto customer) {
		String accNo = customerService.addCustomer(customer);
		if (accNo.equalsIgnoreCase("Invalid")) {
			return "Invalid Age";
		} else {
			return "Thank You!!! Your Account Number is " + accNo;
		}

	}

	@GetMapping("/{phoneNo}")
	public CustomerResponseDto getCustomerbyPhoneNo(@PathVariable String phoneNo) {
		CustomerResponseDto customerDto = customerService.getCustomerbyPhoneNo(phoneNo);

		return customerDto;
	}

}
