package com.estudo.estudo.controller;

import com.estudo.estudo.model.Aluno;
import com.estudo.estudo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public List<Aluno> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable int id) {
        Aluno aluno = service.getById(id);
        return ResponseEntity.ok().body(aluno);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno insert(@RequestBody Aluno aluno) {
        return service.insert(aluno);
    }

    @PutMapping(value = "/{id}")
    public Aluno update(@PathVariable int id, @RequestBody Aluno aluno) {
        return service.update(id, aluno);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/buscarPorLetra/{nome}")
    public List<Aluno> buscarPorLetra(@PathVariable String nome) {
        return service.buscasPorLetra(nome);
    }
    @GetMapping("/ordenarPorNome")
    public List<Aluno> ordenarPorNome() {

        return service.OrdenarPorNome();
    }

    @GetMapping("/buscarID/{id}")
    public Aluno buscarID(@PathVariable int id) {
        return service.buscarID(id);
    }

    @GetMapping("/buscarNome/{nome}")
    public List<Aluno> getByNome(@PathVariable String nome) {
        return service.buscarNome(nome);
    }
}
