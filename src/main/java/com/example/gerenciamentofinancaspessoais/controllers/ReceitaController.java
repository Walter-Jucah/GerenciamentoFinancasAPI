package com.example.gerenciamentofinancaspessoais.controllers;

import com.example.gerenciamentofinancaspessoais.entity.Receita;
import com.example.gerenciamentofinancaspessoais.repository.ReceitaRepository;
import com.example.gerenciamentofinancaspessoais.services.SaldoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/receitas/")
public class ReceitaController {

    private final ReceitaRepository receitaRepository;
    private final SaldoService saldoService;

    @Autowired
    public ReceitaController(ReceitaRepository receitaRepository, SaldoService saldoService) {
        this.receitaRepository = receitaRepository;
        this.saldoService = saldoService;
    }

    //operacoes de crud

    @GetMapping
    public List<Receita> getAllReceitas() {
        return receitaRepository.findAll();
    }
    @GetMapping("/{id}") // Alterando o mapeamento para /api/receitas/{id}
    public Receita getReceitaById(@PathVariable long id) throws Throwable {
        return receitaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Receita não encontrada com ID: " + id));
    }

    @PostMapping("/")
    public Receita addReceita(@RequestBody Receita receita) {
        return (Receita) receitaRepository.save(receita);
    }

    @PutMapping("/{id}")
    public Receita updateReceita(@PathVariable long id, @RequestBody Receita receitaAtualizada) {
        Optional<Receita> optionalReceita = receitaRepository.findById(id);

        if (optionalReceita.isPresent()) {
            Receita receita = optionalReceita.get();
            receita.setData(receitaAtualizada.getData());
            receita.setDescricao(receitaAtualizada.getDescricao());
            receita.setValor(receitaAtualizada.getValor());
            receita.setCategoria(receitaAtualizada.getCategoria());

            return receitaRepository.save(receita);
        } else {
            throw new RuntimeException("Receita não encontrada com ID: " + id);
        }
    }



    @DeleteMapping("/{id}")
    public void deleteReceita(@PathVariable long id) {

        receitaRepository.deleteById(id);
    }
}
