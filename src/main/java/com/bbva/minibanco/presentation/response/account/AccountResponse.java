package com.bbva.minibanco.presentation.response.account;

import com.bbva.minibanco.domain.models.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
public class AccountResponse {
    private int accountNumber;
    private BigDecimal balance;
    private String currency;
    private List<Client> clients;
    private boolean active;

}
