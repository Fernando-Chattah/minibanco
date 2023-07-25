package com.bbva.minibanco.application.usecases.transaction;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.transaction.Transaction;

import java.util.List;

public interface ITransactionListUseCase {
    List<Transaction> getTransactionList();
}
