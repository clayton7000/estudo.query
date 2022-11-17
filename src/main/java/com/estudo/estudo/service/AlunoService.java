package com.estudo.estudo.service;

import com.estudo.estudo.exception.AlunoException;
import com.estudo.estudo.model.Aluno;
import com.estudo.estudo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public List<Aluno> getAll() {
        return repository.findAll();
    }

    public Aluno getById(Integer id) {
        Optional<Aluno> obj = repository.findById(id);
        return obj.orElseThrow(() -> new AlunoException(id));

    }
    @Transactional
    public Aluno insert(Aluno aluno) {
        return repository.save(aluno);
    }
    @Transactional
    public Aluno update(Integer id, Aluno aluno) {
        Aluno alunoAtual = getById(id);
        alunoAtual.setNome(aluno.getNome());
        alunoAtual.setNota(aluno.getNota());
        return repository.save(aluno);
    }

    @Transactional
    public void delete(Integer id) {
        getById(id);
        repository.deleteById(id);
    }
    public List<Aluno> buscarNome(String nome) {
        return repository.buscarNome(nome);

    }

    public Aluno buscarID(int id) {
        return repository.buscarID1(id);

    }

    public List<Aluno> buscasPorLetra(String nome) {
        return repository.findByNomeContaining(nome);

    }
    public List<Aluno> OrdenarPorNome() {

        return repository.OrderByNome();
    }

    public Aluno getByAll(Integer id) {
        Optional<Aluno> obj = repository.findById(id);
        return obj.orElseThrow();

    }

}
