package com.test.bank.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.test.bank.repository.IAccountRepository;
import com.test.bank.repository.IMovementsRepository;
import com.test.bank.repository.entity.MovementsEntity;
import com.test.bank.service.IMovementsService;
import com.test.bank.service.converter.movements.MovementsConverter;
import com.test.bank.service.converter.movements.MovementsEntityConverter;
import com.test.bank.service.model.Movements;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovementsService implements IMovementsService {
  
  private final IMovementsRepository movementsRepository;
  private final IAccountRepository accountRepository;

  @Override
  public Flux<Movements> getMovements(String initialDate, String endDate, String accountNumber) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Mono<Movements> doMovement(Movements movements) {
    return Mono.just(movements)
      .flatMap(this::validateDailyLimit)
      .map(this::validateBalance)
      .map(this::calculateNewBalance)
      .map(MovementsEntityConverter::convert)
      .map(movementsRepository::save)
      .map(MovementsConverter::convert);
  }
  
  private Movements validateBalance(Movements movements) {
    Optional<MovementsEntity> lastMovement = movementsRepository.findTopByOrderByMovementsIdDesc();
    if (!lastMovement.isPresent()) {
      return accountRepository.findByNumber(movements.getAccountNumber())
        .filter(account -> validBalance(movements, account.getInitialBalance()))
        .map(account -> movements.toBuilder().balance(account.getInitialBalance()).build())
        .orElseThrow();
    }
    
    return lastMovement.map(MovementsEntity::getBalance)
      .filter(balance -> validBalance(movements, balance))
      .map(balance -> movements.toBuilder().balance(balance).build())
      .orElseThrow();
  }

  private boolean validBalance(Movements movements, BigDecimal balance) {
    if (movements.getType().equals("CREDIT")) {
      return true;
    }
	return balance.compareTo(movements.getValue()) >= 0;
  }
  
  private Movements calculateNewBalance(Movements movements) {
    BigDecimal newBalance = BigDecimal.ZERO;
    if(movements.getType().equals("DEBIT")) {
      newBalance = movements.getBalance().subtract(movements.getValue());
    } else {
      newBalance = movements.getBalance().add(movements.getValue());
    }
    movements.setBalance(newBalance);
    return movements;
  }
  
  private Mono<Movements> validateDailyLimit(Movements movements) {
    if (movements.getType().equals("DEBIT")) {
      List<BigDecimal> acumDailyAmount = movementsRepository.findAllByDateAndType(LocalDate.now(), "DEBIT").stream()
    		  .map(MovementsEntity::getValue)
    		  .collect(Collectors.toList());
      acumDailyAmount.add(movements.getValue());
      return acumDailyAmount.stream()
        .reduce((a, b) -> a.add(b))
        .filter(dailyAmount -> dailyAmount.compareTo(BigDecimal.valueOf(1000.0))<= 0)
        .map(x -> Mono.just(movements))
        .orElse(Mono.error(new Exception("Limite Diario Excedido")));
    }
    return Mono.just(movements);
  }
  
  

}
