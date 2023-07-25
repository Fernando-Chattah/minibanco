package com.bbva.minibanco.application.usecases.client;

import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.presentation.request.client.ClientCreateRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IClientFindByUseCase {

    Optional<Client> findById(int id);

    Optional<Client> findByPersonalId(String personalId);

}
