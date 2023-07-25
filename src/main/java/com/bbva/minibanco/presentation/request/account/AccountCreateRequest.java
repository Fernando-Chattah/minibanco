package com.bbva.minibanco.presentation.request.account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;

@Getter
public class AccountCreateRequest {

    private int clientId;

    @NotBlank(message = "la moneda no puede estar vacia")
    @Size(min = 3, max = 3, message = "El nombre debe tener entre 2 y 30 caracteres")
    private String currency;

}
