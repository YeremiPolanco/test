package com.test.bank.controller.converter.movements;

import com.test.bank.controller.model.movements.MovementsResponse;
import com.test.bank.service.model.Movements;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MovementsResponseConverter {

  public MovementsResponse convert(Movements movements) {
    return MovementsResponse.builder()
      .movementId(movements.getMovementsId())
      .date(movements.getDate())
      .accountNumber(movements.getAccountNumber())
      .value(movements.getValue())
      .balance(movements.getBalance())
      .build();
  }
}
