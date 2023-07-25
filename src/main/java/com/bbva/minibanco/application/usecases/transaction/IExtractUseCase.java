package com.bbva.minibanco.application.usecases.transaction;

import com.bbva.minibanco.presentation.request.transaction.DepositRequest;
import com.bbva.minibanco.presentation.request.transaction.ExtractionRequest;
import com.bbva.minibanco.utilities.TransactionResponse;
import com.bbva.minibanco.utilities.exceptions.TransactionException;

public interface IExtractUseCase {
    TransactionResponse extract(ExtractionRequest extractRequest) throws TransactionException;
}
