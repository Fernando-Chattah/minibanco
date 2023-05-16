package com.bbva.minibanco.application.repository;

import com.bbva.minibanco.domain.model.Cliente;

public interface IClienteRepository {
    Cliente create(Cliente cliente);
}
