package com.bbva.minibanco.infrastructure.mapper;

import com.bbva.minibanco.domain.model.Cliente;
import com.bbva.minibanco.infrastructure.entities.ClienteEntity;

public class ClienteMapper {
    public ClienteEntity toEntity(Cliente cliente) {

        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNombre(cliente.getNombre());
        clienteEntity.setApellido(cliente.getApellido());
        clienteEntity.setCalle(cliente.getCalle());
        clienteEntity.setNumero(cliente.getNumero());
        clienteEntity.setDepartamento(cliente.getDepartamento());
        clienteEntity.setPiso(cliente.getPiso());
        clienteEntity.setCiudad(cliente.getCiudad());
        clienteEntity.setCodigoPostal(cliente.getCodigoPostal());
        clienteEntity.setProvincia(cliente.getProvincia());
        clienteEntity.setTelefono(cliente.getTelefono());
        clienteEntity.setEmail(cliente.getEmail());
        return clienteEntity;
    }
}
