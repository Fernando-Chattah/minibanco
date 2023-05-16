package com.bbva.minibanco.infrastructure.mapper;

import com.bbva.minibanco.domain.model.Cuenta;
import com.bbva.minibanco.infrastructure.entities.CuentaEntity;

import java.math.BigDecimal;
import java.util.Date;

public class CuentaMapper {
    public CuentaEntity toEntity(Cuenta cuenta) {
        CuentaEntity cuentaEntity = new CuentaEntity();
        cuentaEntity.setNumero(cuenta.getNumero());
        cuentaEntity.setFechaCreacion(cuenta.getFechaCreacion());
        cuentaEntity.setSaldoInicial(cuenta.getSaldoInicial());
        cuentaEntity.setSaldoActual(cuenta.getSaldoActual());
        cuentaEntity.setDescubierto(cuenta.getDescubierto());
        cuentaEntity.setFechaCierre(cuenta.getFechaCierre());

        return cuentaEntity;
    }
}
