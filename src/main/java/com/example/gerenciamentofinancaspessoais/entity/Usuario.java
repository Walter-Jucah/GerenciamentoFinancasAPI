package com.example.gerenciamentofinancaspessoais.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private BigDecimal metaFinanceira;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario() {
    }

    public Usuario(BigDecimal metaFinanceira) {
        this.metaFinanceira = metaFinanceira;
    }

    public BigDecimal getMetaFinanceira() {
        return metaFinanceira;
    }

    public void setMetaFinanceira(BigDecimal metaFinanceira) {
        this.metaFinanceira = metaFinanceira;
    }
}
