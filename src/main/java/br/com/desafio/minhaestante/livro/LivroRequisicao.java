package br.com.desafio.minhaestante.livro;

import jakarta.validation.constraints.NotBlank;

// DTO: representa os dados que o cliente envia para criar ou atualizar um livro.
// @NotBlank impede texto vazio ou contendo somente espaços.
public record LivroRequisicao(
        @NotBlank(message = "Título é obrigatório") String titulo,
        @NotBlank(message = "Autor é obrigatório") String autor,
        boolean lido) {
}
