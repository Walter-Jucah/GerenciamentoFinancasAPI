package com.example.gerenciamentofinancaspessoais.services;

import com.example.gerenciamentofinancaspessoais.repository.DespesaRepository;
import com.example.gerenciamentofinancaspessoais.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SaldoService {
    private final ReceitaRepository receitaRepository;
    private final DespesaRepository despesaRepository;

    @Autowired
    public SaldoService(ReceitaRepository receitaRepository, DespesaRepository despesaRepository) {
        this.receitaRepository = receitaRepository;
        this.despesaRepository = despesaRepository;
    }

    public BigDecimal calcularSaldo() {
        BigDecimal totalReceitas = receitaRepository.sumValorReceitas();
        BigDecimal totalDespesas = despesaRepository.sumValorDespesas();

        //para nao dar problemas com valores nulos
        if (totalDespesas == null) {
            totalDespesas = BigDecimal.ZERO;
        }

        if (totalReceitas == null) {
            totalReceitas= BigDecimal.ZERO;
        }

        return totalReceitas.subtract(totalDespesas);
    }
}
