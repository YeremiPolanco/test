package com.test.bank.service.converter;

import com.test.bank.repository.entity.AccountEntity;
import com.test.bank.service.model.Account;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountEntityConverter {

	public AccountEntity convert(Account account) {
		AccountEntity accountEntity = new AccountEntity();
		return accountEntity;
	}
}
