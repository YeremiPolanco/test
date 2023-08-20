package com.test.bank.service;

import com.test.bank.service.model.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountService {
  
  Flux<Account> getAccounts();
  Mono<Account> createAccount(Account account, String customerName);
  Mono<Account> updateAccount(Account account, Integer id);
  Mono<Void> deleteAccount(Integer id);

}
