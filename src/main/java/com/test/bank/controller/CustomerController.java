package com.test.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.test.bank.service.impl.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
}
