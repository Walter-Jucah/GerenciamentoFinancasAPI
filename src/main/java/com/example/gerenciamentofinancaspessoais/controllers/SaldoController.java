package com.example.gerenciamentofinancaspessoais.controllers;

import com.example.gerenciamentofinancaspessoais.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/saldo")
public class SaldoController {

    private final SaldoService saldoService;

    @Autowired
    public SaldoController(SaldoService saldoService) {
        this.saldoService = saldoService;
    }

    @GetMapping
    public BigDecimal getSaldoAtual() {
        return saldoService.calcularSaldo();
    }
}
