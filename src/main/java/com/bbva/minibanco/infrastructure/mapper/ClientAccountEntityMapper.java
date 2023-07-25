package com.bbva.minibanco.infrastructure.mapper;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.domain.models.ClientAccount;
import com.bbva.minibanco.infrastructure.entities.ClientAccountEntity;
import com.bbva.minibanco.infrastructure.entities.ClientAccountId;
import com.bbva.minibanco.infrastructure.entities.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component()
@RequiredArgsConstructor
public class ClientAccountEntityMapper {

    public ClientAccount entityToDomain(ClientAccountEntity clientAccountEntity) {
        ClientAccount clientAccount = new ClientAccount();

        clientAccount.setClient(new Client(
                clientAccountEntity.getClient().getId(),
                clientAccountEntity.getClient().getPersonalId(),
                clientAccountEntity.getClient().getFirstName(),
                clientAccountEntity.getClient().getLastName(),
                clientAccountEntity.getClient().getEmail(),
                clientAccountEntity.getClient().getAddress(),
                clientAccountEntity.getClient().getPhone(),
                clientAccountEntity.getClient().isActive(),
                null,
                null,
                null
        ));
        clientAccount.setAccount(new Account(
                clientAccountEntity.getAccount().getId(),
                clientAccountEntity.getAccount().getBalance(),
                clientAccountEntity.getAccount().getCurrency(),
                clientAccountEntity.getAccount().isActive(),
                null
        ));
        clientAccount.setAccountHolderType(clientAccountEntity.getHolderType());

        return clientAccount;

    }

    public ClientAccountEntity domainToEntity(ClientAccount clientAccount) {
        /*return ClientAccountEntity.builder()
                .id(new ClientAccountId(clientAccount.getAccount().))*/
        return null;
    }

}
