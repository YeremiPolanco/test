package com.test.bank.controller.converter.customer;

import com.test.bank.controller.model.customer.CustomerResponse;
import com.test.bank.service.model.Customer;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerResponseConverter {

  public CustomerResponse convert(Customer customer) {
    return CustomerResponse.builder()
      .customerId(customer.getCustomerId())
      .password(customer.getPassword())
      .state(customer.getState())
      .name(customer.getName())
      .gender(customer.getGender())
      .age(customer.getAge())
      .identification(customer.getIdentification())
      .address(customer.getAddress())
      .phoneNumber(customer.getPhoneNumber())
      .build();
  }
}
