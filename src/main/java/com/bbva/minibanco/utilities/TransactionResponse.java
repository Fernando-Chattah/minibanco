package com.bbva.minibanco.utilities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class TransactionResponse {
    private int id;
    private String transactionType;
    private BigDecimal amount;
    private int accountFrom;
    private int accountTo;
    private int clientId;
}
