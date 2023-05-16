package com.bbva.minibanco.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private Date fechaCreacion;
    private BigDecimal saldoActual;
    private BigDecimal saldoInicial;
    private BigDecimal descubierto;
    private Date fechaCierre;
    private String codigoCliente;
    @JoinColumn(name = "codigoCliente")
    @OneToOne(fetch = FetchType.LAZY)
    private ClienteEntity cliente;
}
