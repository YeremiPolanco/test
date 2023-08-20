package com.test.bank.controller.converter.account;

import com.test.bank.controller.model.account.AccountRequest;
import com.test.bank.service.model.Account;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountConverter {

  public Account convert(AccountRequest accountRequest) {
    return Account.builder()
      .number(accountRequest.getNumber())
      .type(accountRequest.getType())
      .initialBalance(accountRequest.getInitialBalance())
      .state(accountRequest.getState())
      .build();
  }
}
