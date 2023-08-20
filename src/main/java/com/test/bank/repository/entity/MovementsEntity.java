package com.test.bank.repository.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movements")
@Getter
@Setter
public class MovementsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "movements_id")
  private Integer movementsId;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "type")
  private String type;

  @Column(name = "value")
  private BigDecimal value;

  @Column(name = "balance")
  private BigDecimal balance;

  @ManyToOne
  @JoinColumn(name = "account_id", insertable = false, updatable = false)
  private AccountEntity accountEntity;
  
  public MovementsEntity fillAccountEntity(AccountEntity accountEntity) {
    this.setAccountEntity(accountEntity);
    return this;
  }

}
