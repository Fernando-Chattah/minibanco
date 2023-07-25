package com.bbva.minibanco.infrastructure.repositories.springdatajpa;

import com.bbva.minibanco.infrastructure.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAccountSpringRepository extends JpaRepository<AccountEntity, Integer> {

}
