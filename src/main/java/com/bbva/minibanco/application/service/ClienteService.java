package com.bbva.minibanco.application.service;

import com.bbva.minibanco.application.repository.IClienteRepository;
import com.bbva.minibanco.application.usecases.client.IClienteCreateUseCase;
import com.bbva.minibanco.domain.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteCreateUseCase {
    private IClienteRepository clienteRepository;
    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.create(cliente);
    }
}
