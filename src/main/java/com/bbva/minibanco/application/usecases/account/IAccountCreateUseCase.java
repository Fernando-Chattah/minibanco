package com.bbva.minibanco.application.usecases.account;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.utilities.exceptions.RecordNotFoundException;

public interface IAccountCreateUseCase {

    public Account create(int clientId, String currency) throws RecordNotFoundException;

}
