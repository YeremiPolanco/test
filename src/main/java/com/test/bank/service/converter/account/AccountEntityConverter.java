package com.test.bank.service.converter.account;

import com.test.bank.repository.entity.AccountEntity;
import com.test.bank.service.model.Account;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountEntityConverter {

  public AccountEntity convert(Account account) {
    AccountEntity accountEntity = new AccountEntity();
    accountEntity.setInitialBalance(account.getInitialBalance());
    accountEntity.setNumber(account.getNumber());
    accountEntity.setType(account.getType());
    accountEntity.setState(account.getState());
    return accountEntity;
  }
}
