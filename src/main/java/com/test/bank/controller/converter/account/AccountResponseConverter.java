package com.test.bank.controller.converter.account;

import com.test.bank.controller.model.account.AccountResponse;
import com.test.bank.service.model.Account;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountResponseConverter {

  public AccountResponse convert(Account account) {
    return AccountResponse.builder()
      .accountId(account.getAccountId())
      .number(account.getNumber())
      .type(account.getType())
      .initialBalance(account.getInitialBalance())
      .state(account.getState())
      .build();
  }
}
