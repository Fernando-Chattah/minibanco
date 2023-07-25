package com.bbva.minibanco.domain.models.transaction;

import com.bbva.minibanco.domain.models.ClientAccount;
import com.bbva.minibanco.utilities.AppConstants;
import com.bbva.minibanco.utilities.TransactionTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
public class Deposit extends Transaction {

    public Deposit(ClientAccount targetAccount, BigDecimal amount){
        this.setTransactionType(TransactionTypes.DEPOSIT);
        this.setAccount(targetAccount);
        this.setAmount(amount);
    }
    @Override
    public boolean isValid() {
        // validations to check if a deposit is valid
        return true;
    }

    @Override
    public void applyFundsMovements() {
        this.getAccount().getAccount().setBalance(this.getAccount().getAccount().getBalance().add(this.getAmount()));
    }
}
