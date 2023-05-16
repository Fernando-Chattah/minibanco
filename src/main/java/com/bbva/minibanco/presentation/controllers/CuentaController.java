package com.bbva.minibanco.presentation.controllers;

import com.bbva.minibanco.application.usecases.client.ICuentaCreateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {
    private final ICuentaCreateUseCase cuentaService;

    @Autowired
    public CuentaController(ICuentaCreateUseCase cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping("/create")
    public String create() {
        return "Cuenta";
    }
}
