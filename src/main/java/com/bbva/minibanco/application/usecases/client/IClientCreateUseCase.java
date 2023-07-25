package com.bbva.minibanco.application.usecases.client;

import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.presentation.request.client.ClientCreateRequest;
import com.bbva.minibanco.presentation.response.client.ClientCreateResponse;
import com.bbva.minibanco.utilities.exceptions.ErrorWhenSavingException;
import com.bbva.minibanco.utilities.exceptions.ExistingPersonalIdException;

public interface IClientCreateUseCase {

    ClientCreateResponse create(ClientCreateRequest request) throws ExistingPersonalIdException, ErrorWhenSavingException;

}
