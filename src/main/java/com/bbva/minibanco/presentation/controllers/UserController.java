package com.bbva.minibanco.presentation.controllers;

import com.bbva.minibanco.infrastructure.entities.UserEntity;
import com.bbva.minibanco.infrastructure.repositories.springdatajpa.IUserSpringRepository;
import com.bbva.minibanco.presentation.request.client.ClientCreateRequest;
import com.bbva.minibanco.presentation.response.client.ClientCreateResponse;
import com.bbva.minibanco.presentation.response.errors.ErrorResponse;
import com.bbva.minibanco.utilities.ErrorDescriptions;
import com.bbva.minibanco.utilities.Roles;
import com.bbva.minibanco.utilities.exceptions.ErrorWhenSavingException;
import com.bbva.minibanco.utilities.exceptions.ExistingPersonalIdException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserSpringRepository userSpringRepository;
    private final PasswordEncoder passwordEncoder;
    @PostMapping(value = "/create")
    public ResponseEntity<?> create() {

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername("int_40379479");
        userEntity.setPassword(passwordEncoder.encode("bbva1234"));
        userEntity.setRole(Roles.ADMIN);

        userSpringRepository.save(userEntity);

        return null;
    }
}
