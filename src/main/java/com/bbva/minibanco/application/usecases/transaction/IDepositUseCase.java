package com.bbva.minibanco.application.usecases.transaction;

import com.bbva.minibanco.presentation.request.transaction.DepositRequest;
import com.bbva.minibanco.utilities.TransactionResponse;
import com.bbva.minibanco.utilities.exceptions.TransactionException;

public interface IDepositUseCase {
    TransactionResponse deposit(DepositRequest depositRequest) throws TransactionException;
}
