package com.bbva.minibanco.application.usecases.client;

import com.bbva.minibanco.domain.model.Cliente;

public interface IClienteCreateUseCase {
    Cliente create(Cliente cliente);
}
