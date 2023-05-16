package com.bbva.minibanco.application.service;

import com.bbva.minibanco.application.repository.ICuentaRepository;
import com.bbva.minibanco.application.usecases.client.ICuentaCreateUseCase;
import com.bbva.minibanco.domain.model.Cuenta;
import org.springframework.stereotype.Service;

@Service
public class CuentaService implements ICuentaCreateUseCase {
    private ICuentaRepository cuentaRepository;
    @Override
    public Cuenta create(Cuenta cuenta) {
        return cuentaRepository.create(cuenta);
    }
}