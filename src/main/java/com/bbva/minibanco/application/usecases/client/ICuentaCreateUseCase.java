package com.bbva.minibanco.application.usecases.client;

import com.bbva.minibanco.domain.model.Cuenta;

public interface ICuentaCreateUseCase {
    Cuenta create(Cuenta cuenta);
}
