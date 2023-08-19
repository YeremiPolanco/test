package com.test.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bank.repository.IAccountRepository;
import com.test.bank.repository.IMovementsRepository;

@Service
public class MovementsService {

	@Autowired
	private IMovementsRepository movementsRepository;
}
