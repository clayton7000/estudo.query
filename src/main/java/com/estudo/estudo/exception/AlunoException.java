package com.estudo.estudo.exception;

public class AlunoException extends EntidadeNaoEncontradaException{
    private static final long serialVersionUID = 1L;

    public AlunoException(String mensagem) {
        super(mensagem);
    }

    public AlunoException(Integer id) {
        this(String.format("Não existe aluno cadastrado %d", id));
    }
}
