package com.bbva.minibanco.application.usecases.clientaccount;

import com.bbva.minibanco.domain.models.ClientAccount;
import com.bbva.minibanco.presentation.request.clientaccount.ClientAccountCreateRequest;
import com.bbva.minibanco.utilities.exceptions.AccountNotFoundException;
import com.bbva.minibanco.utilities.exceptions.ClientNotFoundException;
import com.bbva.minibanco.utilities.exceptions.RelationshipNotCreatedException;

public interface IRelateClientAccountUseCase {
    ClientAccount relate(ClientAccountCreateRequest request) throws ClientNotFoundException, RelationshipNotCreatedException, AccountNotFoundException;
}
