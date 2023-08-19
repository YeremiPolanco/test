package com.test.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.bank.controller.converter.AccountResponseConverter;
import com.test.bank.controller.model.AccountResponse;
import com.test.bank.service.impl.AccountService;

import reactor.core.publisher.Flux;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account")
	public Flux<AccountResponse> getAccounts() {
		return accountService.getAccounts()
				.map(AccountResponseConverter::convert);
	}
}
