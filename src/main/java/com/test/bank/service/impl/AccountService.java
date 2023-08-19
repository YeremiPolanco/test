package com.test.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bank.repository.IAccountRepository;
import com.test.bank.service.IAccountService;
import com.test.bank.service.converter.AccountConverter;
import com.test.bank.service.model.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public Flux<Account> getAccounts() {
		return Flux.fromIterable(accountRepository.findAll())
				.map(AccountConverter::convert);
	}

	@Override
	public Mono<Account> createAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Account> updateAccount(Account account, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Boolean> deleteAccount(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
