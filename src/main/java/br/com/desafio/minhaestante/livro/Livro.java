package br.com.desafio.minhaestante.livro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Informa ao JPA que esta classe representa uma tabela do banco de dados.
@Entity
@Table(name = "livros")
public class Livro {

    @Id // Identifica a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o ID automaticamente.
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(nullable = false, length = 120)
    private String autor;

    private boolean lido;

    // O JPA precisa de um construtor sem parâmetros para criar objetos a partir do banco.
    public Livro() {
    }

    // Usamos este construtor quando queremos criar um livro novo.
    public Livro(String titulo, String autor, boolean lido) {
        this.titulo = titulo;
        this.autor = autor;
        this.lido = lido;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isLido() {
        return lido;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
    }
}
