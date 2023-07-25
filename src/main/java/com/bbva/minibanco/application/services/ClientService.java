package com.bbva.minibanco.application.services;

import com.bbva.minibanco.application.repository.IClientRepository;
import com.bbva.minibanco.application.usecases.client.*;
import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.domain.models.ClientAccount;
import com.bbva.minibanco.presentation.mapper.ClientPresentationMapper;
import com.bbva.minibanco.presentation.request.EnableDisableRequest;
import com.bbva.minibanco.presentation.request.client.ClientCreateRequest;
import com.bbva.minibanco.presentation.request.client.ClientUpdateRequest;
import com.bbva.minibanco.presentation.response.client.ClientCreateResponse;
import com.bbva.minibanco.utilities.AppConstants;
import com.bbva.minibanco.utilities.ErrorCodes;
import com.bbva.minibanco.utilities.exceptions.ErrorWhenSavingException;
import com.bbva.minibanco.utilities.exceptions.ExistingPersonalIdException;
import com.bbva.minibanco.utilities.exceptions.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientCreateUseCase, IClientFindByUseCase, IClientUpdateUseCase, IClientListUseCase, IClientEnableDisableUseCase {

    private final IClientRepository clientRepository;
    private final ClientPresentationMapper clientMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ClientCreateResponse create(ClientCreateRequest request) throws ExistingPersonalIdException, ErrorWhenSavingException {

        // server side validations
        if (clientRepository.existsByPersonalId(request.getPersonalId())) {
            throw new ExistingPersonalIdException(ErrorCodes.COULD_NOT_CREATE_CLIENT);
        }

        // creo un salt y hasheo la contraseña
        String salt = BCrypt.gensalt();
        //String hashedPassword = BCrypt.hashpw(request.getPassword(), salt);
        String hashedPassword = passwordEncoder.encode(request.getPassword());

        // Creo la entidad cliente con los datos que tengo
        Client client = clientMapper.requestToDomain(request);
        client.setSalt(salt);
        client.setPassword(hashedPassword);
        client.setActive(true);

        // Creo la cuenta por default que nos exige el negocio
        Account account = Account.builder()
                .currency(AppConstants.getDefaultCurrency())
                .balance(BigDecimal.ZERO)
                .active(true)
                .build();

        // Creo la relacion cliente cuenta y la agrego a una lista
        List<ClientAccount> clientAccountList = new ArrayList<ClientAccount>();
        clientAccountList.add(ClientAccount.builder()
                .client(client)
                .account(account)
                .accountHolderType(AppConstants.getDefaultHolderType())
                .build());

        // Asigno la relacion a los objetos
        client.setAccounts(clientAccountList);
        account.setClients(clientAccountList);

        Client savedClient = clientRepository.saveClient(client);


        // response
        return clientMapper.domainToResponse(savedClient);
    }

    @Override
    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> findByPersonalId(String personalId) {
        return clientRepository.findByPersonalId(personalId);
    }

    @Override
    public ClientCreateResponse update(ClientUpdateRequest request) throws ExistingPersonalIdException, ErrorWhenSavingException, RecordNotFoundException {

        Optional<Client> currentClient = clientRepository.findById(request.getId());
        if(currentClient.isPresent()) {
            currentClient.get().setPersonalId(request.getPersonalId());
            currentClient.get().setLastName(request.getLastName());
            currentClient.get().setFirstName(request.getFirstName());
            currentClient.get().setEmail(request.getEmail());
            currentClient.get().setPhone(request.getPhone());
            currentClient.get().setAddress(request.getAddress());
        } else {
            throw new RecordNotFoundException(ErrorCodes.RECORD_NOT_FOUND);
        }


        // server side validations
        if (clientRepository.existsByPersonalId(request.getPersonalId())) {
            Optional<Client> clientByPersonalId = clientRepository.findByPersonalId(request.getPersonalId());
            if(request.getId() != clientByPersonalId.get().getId())
                throw new ExistingPersonalIdException(ErrorCodes.COULD_NOT_UPDATE_CLIENT);
        }



        Client savedClient = clientRepository.updateClient(currentClient.get());
        for (ClientAccount clientAccount: currentClient.get().getAccounts()) {
            savedClient.getAccounts().add(clientAccount);
        }

        return clientMapper.domainToResponse(savedClient);
    }

    @Override
    public List<Client> getClientsList() {
        return clientRepository.findAll();
    }

    @Override
    public ClientCreateResponse switchActive(EnableDisableRequest request) throws RecordNotFoundException, ErrorWhenSavingException {
        Optional<Client> currentClient = clientRepository.findById(request.getId());
        if(currentClient.isPresent()) {
            currentClient.get().setActive(request.isActive());
        } else {
            throw new RecordNotFoundException(ErrorCodes.RECORD_NOT_FOUND);
        }

        Client savedClient = clientRepository.updateClient(currentClient.get());
        for (ClientAccount clientAccount: currentClient.get().getAccounts()) {
            savedClient.getAccounts().add(clientAccount);
        }

        return clientMapper.domainToResponse(savedClient);
    }
}
