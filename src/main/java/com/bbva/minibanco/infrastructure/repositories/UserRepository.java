package com.bbva.minibanco.infrastructure.repositories;

import com.bbva.minibanco.infrastructure.entities.UserEntity;
import com.bbva.minibanco.infrastructure.repositories.springdatajpa.IUserSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final IUserSpringRepository userSpringRepository;

    public UserEntity findByUserName(String username) {
        Optional<UserEntity> userEntity = userSpringRepository.findById(username);
        return userEntity.orElse(null);
    }
}
