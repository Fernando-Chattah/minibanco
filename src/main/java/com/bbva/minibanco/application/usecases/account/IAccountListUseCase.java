package com.bbva.minibanco.application.usecases.account;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;

import java.util.List;

public interface IAccountListUseCase {
    List<Account> getAccountList();
}
