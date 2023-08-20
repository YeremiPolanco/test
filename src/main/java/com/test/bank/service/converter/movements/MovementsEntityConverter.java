package com.test.bank.service.converter.movements;

import java.time.LocalDate;

import com.test.bank.repository.entity.MovementsEntity;
import com.test.bank.service.model.Movements;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MovementsEntityConverter {

  public MovementsEntity convert(Movements movements) {
    MovementsEntity movementsEntity = new MovementsEntity();
    movementsEntity.setDate(LocalDate.now());
    movementsEntity.setType(movements.getType());
    movementsEntity.setValue(movements.getValue());
    movementsEntity.setBalance(movements.getBalance());
    return movementsEntity;
  }
}
