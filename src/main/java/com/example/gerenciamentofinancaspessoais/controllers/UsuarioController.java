package com.example.gerenciamentofinancaspessoais.controllers;

import com.example.gerenciamentofinancaspessoais.entity.Usuario;
import com.example.gerenciamentofinancaspessoais.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // ... outros endpoints ...

    @PutMapping("/{id}/meta")
    public Usuario updateMetaFinanceira(@PathVariable Long id, @RequestBody BigDecimal metaFinanceira) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            usuario.setMetaFinanceira(metaFinanceira);
            return (Usuario) usuarioRepository.save(usuario);
        } else {
            throw new RuntimeException("Usuário não encontrado com ID: " + id);
        }
    }
}
