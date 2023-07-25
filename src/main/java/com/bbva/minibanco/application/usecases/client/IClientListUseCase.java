package com.bbva.minibanco.application.usecases.client;

import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.presentation.request.client.ClientFindRequest;
import com.bbva.minibanco.presentation.response.client.ClientFindResponse;

import java.util.List;

public interface IClientListUseCase {
    List<Client> getClientsList();
}
