package com.bbva.minibanco.presentation.mapper;

import com.bbva.minibanco.domain.models.transaction.Transaction;
import com.bbva.minibanco.utilities.TransactionResponse;
import org.springframework.stereotype.Component;

@Component
public class TransactionPresentationMapper {

    public TransactionResponse domainToResponse(Transaction transaction) {
        return TransactionResponse.builder()
                .id(transaction.getId())
                .transactionType(transaction.getTransactionType())
                .accountFrom(transaction.getAccount().getAccount().getId())
                .amount(transaction.getAmount())
                .clientId(transaction.getAccount().getClient().getId())
                .build();
    }
}
