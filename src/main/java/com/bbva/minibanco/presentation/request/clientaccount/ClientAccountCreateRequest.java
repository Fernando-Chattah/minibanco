package com.bbva.minibanco.presentation.request.clientaccount;

import lombok.Getter;

@Getter
public class ClientAccountCreateRequest {

    private int clientId;
    private int accountId;
    private String holderType;

}
