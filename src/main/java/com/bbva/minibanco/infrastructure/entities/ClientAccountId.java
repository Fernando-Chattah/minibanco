package com.bbva.minibanco.infrastructure.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class ClientAccountId implements Serializable {

    public ClientAccountId(int _accountId, int _clientId) {
        this.accountId = _accountId;
        this.clientId = _clientId;
    }
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "client_id")
    private int clientId;

}
