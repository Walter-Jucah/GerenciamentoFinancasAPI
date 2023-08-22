package com.example.gerenciamentofinancaspessoais.repository;

import com.example.gerenciamentofinancaspessoais.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
