package com.bbva.minibanco.infrastructure.repositories.springdatajpa;

import com.bbva.minibanco.infrastructure.entities.ClientAccountEntity;
import com.bbva.minibanco.infrastructure.entities.ClientAccountId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientAccountSpringRepository extends JpaRepository<ClientAccountEntity, ClientAccountId> {
}
