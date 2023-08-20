package com.test.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.bank.controller.converter.movements.MovementsConverter;
import com.test.bank.controller.converter.movements.MovementsResponseConverter;
import com.test.bank.controller.model.movements.MovementsRequest;
import com.test.bank.controller.model.movements.MovementsResponse;
import com.test.bank.service.IMovementsService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/movements")
@RequiredArgsConstructor
public class MovementsController {

  private final IMovementsService movementsService;
  
  @GetMapping("/report")
  public Flux<MovementsResponse> getMovements(@RequestParam String initalDate, 
		  @RequestParam String endDate, @RequestParam String accountNumber) {
    return movementsService.getMovements(initalDate, endDate, accountNumber)
      .map(MovementsResponseConverter::convert);
  }

  @PostMapping
  public Mono<MovementsResponse> doMovement(@RequestBody MovementsRequest movementsRequest) {
    return movementsService.doMovement(MovementsConverter.convert(movementsRequest))
      .map(MovementsResponseConverter::convert);
  }

}
