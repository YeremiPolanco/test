package com.test.bank.service.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Account {
	
	private String number;
	private String type;
	private BigDecimal initialBalance;
    private String state;

}
