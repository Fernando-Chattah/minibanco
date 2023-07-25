package com.bbva.minibanco.application.repository;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.infrastructure.entities.AccountEntity;
import com.bbva.minibanco.utilities.exceptions.ErrorWhenSavingException;

import java.util.List;
import java.util.Optional;

public interface IAccountRepository {

    Account create(Account account, Client client);
    Optional<Account> findById(int id);
    List<Account> findAll();
    Account updateAccount(Account account) throws ErrorWhenSavingException;


}
