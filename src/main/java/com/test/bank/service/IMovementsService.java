package com.test.bank.service;

import com.test.bank.service.model.Movements;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovementsService {
  
  Flux<Movements> getMovements(String initialDate, String endDate, String accountNumber);
  Mono<Movements> doMovement(Movements movements);

}
