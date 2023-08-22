package com.example.gerenciamentofinancaspessoais.controllers;

import com.example.gerenciamentofinancaspessoais.repository.ReceitaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/relatorios/")
public class RelatorioController {

    private final ReceitaRepository receitaRepository;

    public RelatorioController(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @GetMapping("/mes")
    public List<Object[]> gastosPorMes() {
        return receitaRepository.gastosPorMes();
    }

    @GetMapping("/categoria")
    public List<Object[]> gastosPorCategoria() {
        return receitaRepository.gastosPorCategoria();
    }

    @GetMapping("/ano")
    public List<Object[]> gastosPorAno() {
        return receitaRepository.gastosPorAno();
    }


}
