package com.test.bank.service.impl;

import org.springframework.stereotype.Service;

import com.test.bank.repository.IAccountRepository;
import com.test.bank.repository.ICustomerRepository;
import com.test.bank.repository.entity.AccountEntity;
import com.test.bank.service.IAccountService;
import com.test.bank.service.converter.account.AccountConverter;
import com.test.bank.service.converter.account.AccountEntityConverter;
import com.test.bank.service.model.Account;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

  private final IAccountRepository accountRepository;
  private final ICustomerRepository customerRepository;

  @Override
  public Flux<Account> getAccounts() {
    return Flux.fromIterable(accountRepository.findAll())
      .map(AccountConverter::convert);
  }

  @Override
  public Mono<Account> createAccount(Account account, String customerName) {
    return Mono.just(account)
      .flatMap(this::validateAccountExists)
      .map(AccountEntityConverter::convert)
      .map(accountEntity -> this.setCustomerEntity(accountEntity, customerName))
      .map(accountRepository::save)
      .map(AccountConverter::convert);
  }
  
  private Mono<Account> validateAccountExists(Account account){
    if (accountRepository.findByNumber(account.getNumber()).isPresent()){
      return Mono.error(new Exception("Account ya existe"));
    }
    return Mono.just(account);
  }
  
  private AccountEntity setCustomerEntity(AccountEntity accountEntity, String customerName) {
    return customerRepository.findByName(customerName)
      .map(accountEntity::fillCustomerEntity)
      .orElseThrow(() -> new EntityNotFoundException());
  }

  @Override
  public Mono<Account> updateAccount(Account account, Integer id) {
    return accountRepository.findById(id)
      .map(accountEntity -> accountEntity.generateNewEntity(account))
      .map(accountRepository::save)
      .map(AccountConverter::convert)
      .map(Mono::just)
      .orElseThrow(() -> new EntityNotFoundException());
  }

  @Override
  public Mono<Void> deleteAccount(Integer id) {
    accountRepository.deleteById(id);
    return Mono.empty();
  }
}
