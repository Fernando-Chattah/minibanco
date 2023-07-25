package com.bbva.minibanco.presentation.response.account;

import com.bbva.minibanco.domain.models.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class AccountFindResponse {
    private int id;
    private String currency;
    private BigDecimal balance;
    private List<Client> clientList;
}
