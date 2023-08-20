package com.test.bank.controller.model.movements;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MovementsRequest implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Nonnull
  private String type;
  
  @Nonnull
  private String accountNumber;
  
  @Nonnull
  private BigDecimal value;
  
}
