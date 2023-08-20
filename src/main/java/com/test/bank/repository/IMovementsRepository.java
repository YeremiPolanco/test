package com.test.bank.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.test.bank.repository.entity.MovementsEntity;

public interface IMovementsRepository extends CrudRepository<MovementsEntity, Integer>{
  List<MovementsEntity> findAllByDateAndType(LocalDate date, String type);
  Optional<MovementsEntity> findTopByOrderByMovementsIdDesc();
}
