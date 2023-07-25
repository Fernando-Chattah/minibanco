package com.bbva.minibanco.application.usecases.account;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;

public interface IAccountSaveUseCase {

    Account create(Account account, Client client);

}
