package com.test.bank.service.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Getter
@Setter
public class Movements {
	
  private Integer movementsId;
  private String type;
  private String accountNumber;
  private BigDecimal value;
  private LocalDate date;
  private BigDecimal balance;
  
}
