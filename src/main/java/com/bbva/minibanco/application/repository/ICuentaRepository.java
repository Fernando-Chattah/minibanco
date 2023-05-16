package com.bbva.minibanco.application.repository;

import com.bbva.minibanco.domain.model.Cuenta;

public interface ICuentaRepository {
    Cuenta create(Cuenta cuenta);
}
