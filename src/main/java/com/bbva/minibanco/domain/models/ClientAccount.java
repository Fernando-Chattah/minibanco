package com.bbva.minibanco.domain.models;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientAccount {
    private Client client;
    private Account account;
    private String accountHolderType;

}
