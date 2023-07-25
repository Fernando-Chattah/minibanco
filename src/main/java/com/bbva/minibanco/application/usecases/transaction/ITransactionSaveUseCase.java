package com.bbva.minibanco.application.usecases.transaction;

import com.bbva.minibanco.domain.models.transaction.Transaction;

public interface ITransactionSaveUseCase {
    Transaction save(Transaction transaction);
}
