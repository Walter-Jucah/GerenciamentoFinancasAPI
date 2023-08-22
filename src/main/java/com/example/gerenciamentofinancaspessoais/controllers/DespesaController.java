package com.example.gerenciamentofinancaspessoais.controllers;

import com.example.gerenciamentofinancaspessoais.entity.Despesa;
import com.example.gerenciamentofinancaspessoais.repository.DespesaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/despesas/")
public class DespesaController {

    private final DespesaRepository despesaRepository;

    public DespesaController(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }


    //operacoes de crud

    @GetMapping
    public List<Despesa> getAllDespesas() {
        return despesaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Despesa getDespesaById(@PathVariable Long id) throws Throwable {
        return (Despesa) despesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada com ID: " + id));
    }
    @PostMapping
    public Despesa addDespesa(@RequestBody Despesa despesa) {
        return (Despesa) despesaRepository.save(despesa);
    }

    @PutMapping("/{id}")
    public Despesa updateDespesa(@PathVariable long id, @RequestBody Despesa despesaAtualizada) {
        Optional<Despesa> optionalDespesa = despesaRepository.findById(id);

        if (optionalDespesa.isPresent()) {
            Despesa despesa = optionalDespesa.get();
            despesa.setData(despesaAtualizada.getData());
            despesa.setDescricao(despesaAtualizada.getDescricao());
            despesa.setValor(despesaAtualizada.getValor());
            despesa.setCategoria(despesaAtualizada.getCategoria());

            return (Despesa) despesaRepository.save(despesa);
        } else {
            throw new RuntimeException("Despesa não encontrada com ID: " + id);
        }
    }

    @DeleteMapping
    public void deleteDespesa(@PathVariable long id) {
        despesaRepository.deleteById(id);
    }


}
