package com.test.bank.controller.model.movements;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(value = Include.NON_NULL)
public class MovementsResponse {
  Integer movementId;
  LocalDate date;
  String type;
  String accountNumber;
  BigDecimal value;
  BigDecimal balance;
}
