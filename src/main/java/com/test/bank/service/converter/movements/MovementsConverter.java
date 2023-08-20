package com.test.bank.service.converter.movements;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.test.bank.repository.entity.CustomerEntity;
import com.test.bank.repository.entity.MovementsEntity;
import com.test.bank.service.model.Account;
import com.test.bank.service.model.Customer;
import com.test.bank.service.model.Movements;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MovementsConverter {

  public Movements convert(MovementsEntity movementsEntity) {
    return Movements.builder()
      .movementsId(movementsEntity.getMovementsId())
    		.type(movementsEntity.getType())
    		.value(movementsEntity.getValue())
    		.date(movementsEntity.getDate())
    		.balance(movementsEntity.getBalance())
      .build();
    
  }
}
