package com.test.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.bank.repository.entity.AccountEntity;

public interface IAccountRepository extends CrudRepository<AccountEntity, Integer>{

}
