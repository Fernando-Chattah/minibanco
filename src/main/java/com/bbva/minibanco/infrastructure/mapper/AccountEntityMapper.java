package com.bbva.minibanco.infrastructure.mapper;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.domain.models.ClientAccount;
import com.bbva.minibanco.infrastructure.entities.AccountEntity;
import com.bbva.minibanco.infrastructure.entities.ClientAccountEntity;
import com.bbva.minibanco.infrastructure.entities.ClientEntity;
import com.bbva.minibanco.presentation.mapper.AccountPresentationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component()
@RequiredArgsConstructor
public class AccountEntityMapper {

    public AccountEntity domainToEntity(Account account) {

        return AccountEntity.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .active(account.isActive())
                .clientAccounts(new ArrayList<>())
                .build();
    }

    public Account entityToDomain(AccountEntity accountEntity) {
        Account account = new Account();
        account.setId(accountEntity.getId());
        account.setCurrency(accountEntity.getCurrency());
        account.setBalance(accountEntity.getBalance());
        account.setActive(accountEntity.isActive());
        List<ClientAccount> clientAccountList = new ArrayList<>();
        for (ClientAccountEntity clientAccountEntity : accountEntity.getClientAccounts()) {
            ClientEntity clientEntity = clientAccountEntity.getClient();
            Client client = new Client(
                    clientEntity.getId(),
                    clientEntity.getPersonalId(),
                    clientEntity.getFirstName(),
                    clientEntity.getLastName(),
                    clientEntity.getEmail(),
                    clientEntity.getAddress(),
                    clientEntity.getPhone(),
                    clientEntity.isActive(),
                    clientEntity.getPassword(),
                    clientEntity.getSalt(),
                    null
            );
            clientAccountList.add(
                    new ClientAccount(client,account,clientAccountEntity.getHolderType())
            );
        }
        account.setClients(clientAccountList);

        return account;
    }

}
