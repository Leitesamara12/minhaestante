package br.com.desafio.minhaestante.exception;

// Exceção usada quando alguém procura um livro que não existe.
public class LivroNaoEncontradoException extends RuntimeException {

    public LivroNaoEncontradoException(Long id) {
        super("Livro não encontrado com ID: " + id);
    }
}
