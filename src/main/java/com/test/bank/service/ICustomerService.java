package com.test.bank.service;

import com.test.bank.service.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {
  
  Flux<Customer> getCustomers();
  Mono<Customer> createCustomer(Customer customer);
  Mono<Customer> updateCustomer(Customer customer, Integer id);
  Mono<Void> deleteCustomer(Integer id);

}
