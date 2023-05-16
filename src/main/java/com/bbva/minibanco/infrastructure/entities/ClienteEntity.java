package com.bbva.minibanco.infrastructure.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;
    private String apellido;
    private String calle;
    private String numero;
    private String departamento;
    private String piso;
    private String ciudad;
    private String codigoPostal;
    private String provincia;
    private String telefono;
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private CuentaEntity cuenta;
}
