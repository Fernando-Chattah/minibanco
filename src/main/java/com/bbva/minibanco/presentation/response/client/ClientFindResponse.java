package com.bbva.minibanco.presentation.response.client;

import com.bbva.minibanco.domain.models.Account;
import com.bbva.minibanco.domain.models.Client;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class ClientFindResponse {
    private int id;
    private String personalId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
    private List<Account> accountList;

}
