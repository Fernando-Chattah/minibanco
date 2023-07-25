package com.bbva.minibanco.infrastructure.repositories.springdatajpa;

import com.bbva.minibanco.infrastructure.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITransactionSpringRepository extends JpaRepository<TransactionEntity, Integer> {
    List<TransactionEntity> findByClientId(int clientId);
    List<TransactionEntity> findByAccountId(int accountId);
}
