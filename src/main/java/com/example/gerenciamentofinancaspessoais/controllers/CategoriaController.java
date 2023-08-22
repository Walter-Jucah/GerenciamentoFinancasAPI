package com.example.gerenciamentofinancaspessoais.controllers;

import com.example.gerenciamentofinancaspessoais.entity.Categoria;
import com.example.gerenciamentofinancaspessoais.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/categorias/")
public class CategoriaController {
    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    @GetMapping
    public List<Categoria> getAllCategorias() {

        return categoriaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable long id) throws Throwable {

        return (Categoria) categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com ID: " + id));

    }

    @PostMapping
    public Categoria addCategoria(@RequestBody Categoria categoria) {
        return (Categoria) categoriaRepository.save(categoria);
    }


    @PutMapping("/{id}")
    public Categoria updateCategoria(@PathVariable long id, @RequestBody Categoria categoriaAtualizada) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);

        if (optionalCategoria.isPresent()) {
            Categoria categoria = optionalCategoria.get();
            categoria.setNome(categoriaAtualizada.getNome());
            return (Categoria) categoriaRepository.save(categoria);
        } else {
            throw new RuntimeException("Categoria não encontrada com ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void  deleteCategoria(@PathVariable long id) {

        categoriaRepository.deleteById(id);
    }

}
