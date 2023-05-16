package com.bbva.minibanco.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

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

}
