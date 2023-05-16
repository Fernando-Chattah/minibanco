package com.bbva.minibanco.presentation.controllers;

import com.bbva.minibanco.application.usecases.client.IClienteCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final IClienteCreateUseCase clienteService;

    @Autowired
    public ClienteController(IClienteCreateUseCase clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/create")
    public String create() {
        return "Hola";
    }


}
