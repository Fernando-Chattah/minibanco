package com.bbva.minibanco.presentation.request.transaction;

import com.bbva.minibanco.infrastructure.entities.ClientAccountEntity;
import javax.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class TransactionCreateRequest {

    private int accountId;
    private int clientId;
    private BigDecimal amount;
    private String transactionType;
    private String accountTo;


}
