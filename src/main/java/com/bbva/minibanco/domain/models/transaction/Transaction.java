package com.bbva.minibanco.domain.models.transaction;

import com.bbva.minibanco.domain.models.ClientAccount;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Transaction {
    private int id;
    private String transactionType;
    private ClientAccount account;
    private BigDecimal amount;
    public abstract boolean isValid();
    public abstract void applyFundsMovements();

}
