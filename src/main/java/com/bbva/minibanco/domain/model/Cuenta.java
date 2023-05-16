package com.bbva.minibanco.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {

    private Long numero;
    private Date fechaCreacion;
    private BigDecimal saldoActual;
    private BigDecimal saldoInicial;
    private BigDecimal descubierto;
    private Date fechaCierre;

}
