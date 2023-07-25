package com.bbva.minibanco.application.usecases.transaction;

import com.bbva.minibanco.domain.models.transaction.Transaction;

import java.util.List;

public interface ITransactionFindByUseCase {
    List<Transaction> findByClientPersonalId(int personalId);
    List<Transaction> findByClientId(int clientId);
    List<Transaction> findByAccountId(int accountId);
}
