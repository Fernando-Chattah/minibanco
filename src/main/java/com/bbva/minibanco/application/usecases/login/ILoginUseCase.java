package com.bbva.minibanco.application.usecases.login;

import com.bbva.minibanco.presentation.request.login.LoginRequest;
import com.bbva.minibanco.utilities.exceptions.InvalidLoginException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface ILoginUseCase {
    public Optional<UserDetails> login(LoginRequest request) throws InvalidLoginException;
}
