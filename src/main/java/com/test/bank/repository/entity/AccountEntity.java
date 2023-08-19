package com.test.bank.repository.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
public class AccountEntity {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idAccount")
  Integer idAccount;
  
  @Column(name = "number")
  String number;
  
  @Column(name = "type")
  String type;
  
  @Column(name = "initialBalance")
  BigDecimal initialBalance;
  
  @Column(name = "state")
  String state;
  
  @Column(name = "idCustomer")
  String idCustomer;
}
