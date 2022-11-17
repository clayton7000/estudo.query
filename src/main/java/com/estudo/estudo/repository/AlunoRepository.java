package com.estudo.estudo.repository;

import com.estudo.estudo.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    List<Aluno> findByNomeContaining(String nome);

    List<Aluno> OrderByNome();

    @Query("select u from Aluno u where u.id = :id")
    Aluno buscarID1(int id);
    @Query("select u from Aluno u where u.nome = :nome")
    List<Aluno> buscarNome(String nome);
}
