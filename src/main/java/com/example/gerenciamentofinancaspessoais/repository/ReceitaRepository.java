package com.example.gerenciamentofinancaspessoais.repository;

import com.example.gerenciamentofinancaspessoais.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

    @Query("SELECT COALESCE(SUM(r.valor), 0) FROM Receita r")
    BigDecimal sumValorReceitas();

    // Logica de Gastos

    @Query("SELECT r.categoria.nome, COALESCE(SUM(r.valor), 0) FROM Receita r GROUP BY r.categoria.nome")
    List<Object[]> gastosPorCategoria();

    @Query("SELECT CONCAT(YEAR(r.data), '-', MONTH(r.data)), COALESCE(SUM(r.valor), 0) FROM Receita r GROUP BY CONCAT(YEAR(r.data), '-', MONTH(r.data))")
    List<Object[]> gastosPorMes();

    @Query("SELECT YEAR(r.data), COALESCE(SUM(r.valor), 0) FROM Receita r GROUP BY YEAR(r.data)")
    List<Object[]> gastosPorAno();


}
