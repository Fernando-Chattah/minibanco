package com.bbva.minibanco.application.usecases.client;

import com.bbva.minibanco.presentation.request.EnableDisableRequest;
import com.bbva.minibanco.presentation.response.account.AccountResponse;
import com.bbva.minibanco.presentation.response.client.ClientCreateResponse;
import com.bbva.minibanco.utilities.exceptions.ErrorWhenSavingException;
import com.bbva.minibanco.utilities.exceptions.RecordNotFoundException;

public interface IAccountEnableDisableUseCase {
    AccountResponse switchActive(EnableDisableRequest request) throws RecordNotFoundException, ErrorWhenSavingException;
}
