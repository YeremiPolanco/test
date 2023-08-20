package com.test.bank.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.bank.controller.converter.account.AccountConverter;
import com.test.bank.controller.converter.account.AccountResponseConverter;
import com.test.bank.controller.model.account.AccountRequest;
import com.test.bank.controller.model.account.AccountResponse;
import com.test.bank.service.IAccountService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

  private final IAccountService accountService;

  @GetMapping
  public Flux<AccountResponse> getAccounts() {
    return accountService.getAccounts()
      .map(AccountResponseConverter::convert);
  }
	
  @PostMapping
  public Mono<AccountResponse> createAccount(@RequestBody AccountRequest accountRequest) {
    return accountService.createAccount(
        AccountConverter.convert(accountRequest), accountRequest.getCustomerName())
      .map(AccountResponseConverter::convert);
  }
  
  @PatchMapping("/{id}")
  public Mono<AccountResponse> updateAccount(@RequestBody AccountRequest accountRequest,
      @PathVariable Integer id){
    return accountService.updateAccount(AccountConverter.convert(accountRequest), id)
      .map(AccountResponseConverter::convert);
  }
  
  @DeleteMapping("/{id}")
  public Mono<Void> deleteAccount(@PathVariable Integer id){
    return accountService.deleteAccount(id);
  }
  
}
