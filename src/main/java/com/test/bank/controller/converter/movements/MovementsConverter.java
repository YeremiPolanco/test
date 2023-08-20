package com.test.bank.controller.converter.movements;

import com.test.bank.controller.model.movements.MovementsRequest;
import com.test.bank.service.model.Movements;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MovementsConverter {

  public Movements convert(MovementsRequest movementsRequest) {
    return Movements.builder()
      .type(movementsRequest.getType())
      .accountNumber(movementsRequest.getAccountNumber())
      .value(movementsRequest.getValue())
      .build();
  }
}
