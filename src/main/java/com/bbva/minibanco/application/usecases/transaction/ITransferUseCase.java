package com.bbva.minibanco.application.usecases.transaction;

import com.bbva.minibanco.presentation.request.transaction.ExtractionRequest;
import com.bbva.minibanco.presentation.request.transaction.TransferRequest;
import com.bbva.minibanco.utilities.TransactionResponse;
import com.bbva.minibanco.utilities.exceptions.TransactionException;

public interface ITransferUseCase {
    TransactionResponse transfer(TransferRequest extractRequest) throws TransactionException;
}
