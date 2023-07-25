package com.bbva.minibanco.application.usecases.clientaccount;

import com.bbva.minibanco.domain.models.ClientAccount;
import com.bbva.minibanco.infrastructure.entities.ClientAccountEntity;

import java.util.Optional;

public interface IGetClientAccountUseCase {
    ClientAccount get(int clientId, int accountId);
}
