package com.bbva.minibanco.application.repository;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.domain.models.ClientAccount;
import com.bbva.minibanco.infrastructure.entities.ClientAccountEntity;
import com.bbva.minibanco.infrastructure.entities.ClientAccountId;
import com.bbva.minibanco.utilities.exceptions.AccountNotFoundException;
import com.bbva.minibanco.utilities.exceptions.ClientNotFoundException;
import com.bbva.minibanco.utilities.exceptions.RelationshipNotCreatedException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface IClientAccountRepository {

    ClientAccount relateClientToAccount(int clientId, int accountId, String holderType) throws ClientNotFoundException, AccountNotFoundException, RelationshipNotCreatedException;

    ClientAccount get(int clientId, int account);

}
