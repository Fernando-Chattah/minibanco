package com.bbva.minibanco.application.services;

import com.bbva.minibanco.application.repository.IClientAccountRepository;
import com.bbva.minibanco.application.usecases.clientaccount.IGetClientAccountUseCase;
import com.bbva.minibanco.application.usecases.clientaccount.IRelateClientAccountUseCase;
import com.bbva.minibanco.domain.models.ClientAccount;
import com.bbva.minibanco.infrastructure.entities.ClientAccountEntity;
import com.bbva.minibanco.presentation.request.clientaccount.ClientAccountCreateRequest;
import com.bbva.minibanco.utilities.exceptions.AccountNotFoundException;
import com.bbva.minibanco.utilities.exceptions.ClientNotFoundException;
import com.bbva.minibanco.utilities.exceptions.RelationshipNotCreatedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientAccountService implements IRelateClientAccountUseCase, IGetClientAccountUseCase {
    private final IClientAccountRepository clientAccountRepository;
    @Override
    public ClientAccount relate(ClientAccountCreateRequest request) throws ClientNotFoundException, RelationshipNotCreatedException, AccountNotFoundException {
        ClientAccount savedClientAccount = clientAccountRepository.relateClientToAccount(
                request.getClientId(),
                request.getAccountId(),
                request.getHolderType()
        );
        return savedClientAccount;
    }

    @Override
    public ClientAccount get(int clientId, int accountId) {
        return clientAccountRepository.get(clientId, accountId);
    }
}
