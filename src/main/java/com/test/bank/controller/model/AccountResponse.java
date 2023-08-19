package com.test.bank.controller.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AccountResponse {
  String number;
  String type;
  BigDecimal initialBalance;
  String state;
}
