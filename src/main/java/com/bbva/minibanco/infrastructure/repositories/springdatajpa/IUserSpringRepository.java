package com.bbva.minibanco.infrastructure.repositories.springdatajpa;

import com.bbva.minibanco.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserSpringRepository extends JpaRepository<UserEntity, String> {
}
