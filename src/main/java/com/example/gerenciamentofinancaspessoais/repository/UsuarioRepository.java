package com.example.gerenciamentofinancaspessoais.repository;

import com.example.gerenciamentofinancaspessoais.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
