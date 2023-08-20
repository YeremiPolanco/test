package com.test.bank.controller.model.customer;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerRequest implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Nonnull
  private String name;
  
  @Nonnull
  private String address;
  
  @Nonnull
  private String phoneNumber;
  
  @Nonnull
  private String state;
  
  @Nonnull
  private String password;
  
  private String gender;
  
  private Integer age;
  
  private String identification;
  
}
