package com.bbva.minibanco.presentation.mapper;

import com.bbva.minibanco.domain.models.ClientAccount;
import com.bbva.minibanco.presentation.response.clientaccount.ClientAccountResponse;
import org.springframework.stereotype.Component;

@Component
public class ClientAccountPresentationMapper {

    public ClientAccountResponse domainToResponse(ClientAccount clientAccount) {
        return ClientAccountResponse.builder()
                .accountId(clientAccount.getAccount().getId())
                .personalId(clientAccount.getClient().getPersonalId())
                .currency(clientAccount.getAccount().getCurrency())
                .holderType(clientAccount.getAccountHolderType())
                .build();
    }
}
