package com.bbva.minibanco.application.usecases.client;

import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.presentation.request.client.ClientUpdateRequest;
import com.bbva.minibanco.presentation.response.client.ClientCreateResponse;
import com.bbva.minibanco.utilities.exceptions.ErrorWhenSavingException;
import com.bbva.minibanco.utilities.exceptions.ExistingPersonalIdException;
import com.bbva.minibanco.utilities.exceptions.RecordNotFoundException;

public interface IClientUpdateUseCase {

    public ClientCreateResponse update(ClientUpdateRequest client) throws ExistingPersonalIdException, ErrorWhenSavingException, RecordNotFoundException;

}
