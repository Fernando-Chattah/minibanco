package com.bbva.minibanco.application.repository;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.presentation.request.client.ClientFindRequest;
import com.bbva.minibanco.presentation.response.client.ClientFindResponse;
import com.bbva.minibanco.utilities.exceptions.ErrorWhenSavingException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IClientRepository {

    Client saveClient(Client cliente) throws ErrorWhenSavingException;

    Client updateClient(Client client) throws ErrorWhenSavingException;
    List<Client> findAll();
    Optional<Client> findById(int id);
    Optional<Client> findByPersonalId(String personalId);
    boolean existsByPersonalId(String personalId);

}
