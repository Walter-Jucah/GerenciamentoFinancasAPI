package com.example.gerenciamentofinancaspessoais.repository;

import com.example.gerenciamentofinancaspessoais.entity.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    @Query("SELECT COALESCE(SUM(d.valor), 0) FROM Despesa d")
    BigDecimal sumValorDespesas();

}
