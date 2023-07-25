package com.bbva.minibanco.application.usecases.account;

import com.bbva.minibanco.domain.models.Account;

import java.util.Optional;

public interface IAccountFindByUseCase {
    Optional<Account> findById(int id);
}
