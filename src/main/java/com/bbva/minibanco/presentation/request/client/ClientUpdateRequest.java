package com.bbva.minibanco.presentation.request.client;

import lombok.Getter;

@Getter
public class ClientUpdateRequest extends ClientCreateRequest {

    private int id;
    private String newPersonalId;
}
