package com.bbva.minibanco.infrastructure.repositories;

import com.bbva.minibanco.application.repository.IAccountRepository;
import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.infrastructure.entities.AccountEntity;
import com.bbva.minibanco.infrastructure.entities.ClientAccountEntity;
import com.bbva.minibanco.infrastructure.entities.ClientAccountId;
import com.bbva.minibanco.infrastructure.entities.ClientEntity;
import com.bbva.minibanco.infrastructure.mapper.AccountEntityMapper;
import com.bbva.minibanco.infrastructure.mapper.ClientEntityMapper;
import com.bbva.minibanco.infrastructure.repositories.springdatajpa.IAccountSpringRepository;
import com.bbva.minibanco.infrastructure.repositories.springdatajpa.IClientAccountSpringRepository;
import com.bbva.minibanco.utilities.AppConstants;
import com.bbva.minibanco.utilities.ErrorCodes;
import com.bbva.minibanco.utilities.exceptions.ErrorWhenSavingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements IAccountRepository {

    private final AccountEntityMapper accountEntityMapper;
    private final ClientEntityMapper clientEntityMapper;
    private final IAccountSpringRepository accountSpringRepository;
    public final IClientAccountSpringRepository clientAccountSpringRepository;

    @Override
    public Account create(Account account, Client client) {
        // parse the domain objects
        ClientEntity clientEntity = clientEntityMapper.domainToEntity(client);
        AccountEntity accountEntity = accountEntityMapper.domainToEntity(account);
        List<ClientAccountEntity> clientAccountEntityList = new ArrayList<>();
        // persist the account
        accountEntity = accountSpringRepository.save(accountEntity);
        // create the relationship entity
        ClientAccountId clientAccountId = new ClientAccountId(accountEntity.getId(),clientEntity.getId());
        ClientAccountEntity clientAccountEntity = new ClientAccountEntity();
        clientAccountEntity.setId(clientAccountId);
        clientAccountEntity.setAccount(accountEntity);
        clientAccountEntity.setClient(clientEntity);
        clientAccountEntity.setHolderType(AppConstants.getDefaultHolderType());
        // persist the relationship
        clientAccountEntity = clientAccountSpringRepository.save(clientAccountEntity);
        clientAccountEntityList.add(clientAccountEntity);
        accountEntity.setClientAccounts(clientAccountEntityList);

        return accountEntityMapper.entityToDomain(accountEntity);
    }

    @Override
    public Optional<Account> findById(int id) {
        Optional<AccountEntity> optionalAccount = accountSpringRepository.findById(Integer.valueOf(id));
        if (optionalAccount.isEmpty()) {
            return Optional.empty();
        }

        return optionalAccount.map(accountEntityMapper::entityToDomain);
    }

    @Override
    public List<Account> findAll() {
        List<AccountEntity> accountEntityList = new ArrayList<>();
        List<Account> accountList = new ArrayList<>();

        accountEntityList = accountSpringRepository.findAll();

        for (AccountEntity entity : accountEntityList) {
            accountList.add(accountEntityMapper.entityToDomain(entity));
        }

        return accountList;
    }

    @Override
    public Account updateAccount(Account account) throws ErrorWhenSavingException {
        try {
            AccountEntity currentAccount = accountEntityMapper.domainToEntity(account);
            AccountEntity savedAccount = accountSpringRepository.save(currentAccount);
            return accountEntityMapper.entityToDomain(savedAccount);
        } catch (Exception e) {
            throw new ErrorWhenSavingException(ErrorCodes.COULD_NOT_UPDATE_CLIENT);
        }
    }
}
