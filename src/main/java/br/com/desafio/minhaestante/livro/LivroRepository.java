package br.com.desafio.minhaestante.livro;

import org.springframework.data.jpa.repository.JpaRepository;

// O JpaRepository já oferece métodos para salvar, buscar, listar e excluir livros.
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
