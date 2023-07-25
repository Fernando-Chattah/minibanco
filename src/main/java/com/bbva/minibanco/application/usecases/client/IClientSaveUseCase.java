package com.bbva.minibanco.application.usecases.client;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;

public interface IClientSaveUseCase {

    Client save(Client client, Account account);

}
