package com.test.bank.controller.model.account;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountRequest implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Nonnull
  private String number;
  
  @Nonnull
  private String type;
  
  @Nonnull
  private BigDecimal initialBalance;
  
  @Nonnull
  private String state;
  
  @Nonnull
  private String customerName;
}
