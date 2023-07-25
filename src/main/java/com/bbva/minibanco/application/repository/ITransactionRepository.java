package com.bbva.minibanco.application.repository;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.transaction.Deposit;
import com.bbva.minibanco.domain.models.transaction.Extraction;
import com.bbva.minibanco.domain.models.transaction.Transaction;
import com.bbva.minibanco.domain.models.transaction.Transfer;
import com.bbva.minibanco.domain.models.Client;
import com.bbva.minibanco.utilities.exceptions.RecordNotFoundException;
import com.bbva.minibanco.utilities.exceptions.TransactionException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ITransactionRepository {

    Deposit executeDeposit(Deposit deposit) throws TransactionException;
    Extraction executeExtraction(Extraction extraction) throws TransactionException;
    Transfer executeTransfer(Transfer transfer) throws TransactionException;
    Optional<Transaction> findById(int id) throws RecordNotFoundException;
    List<Transaction> findAll();
    List<Transaction> findByClientId(int id);
    List<Transaction> findByAccountId(int id);

}
