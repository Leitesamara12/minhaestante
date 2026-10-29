package br.com.desafio.minhaestante.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

// Centraliza os erros para a API devolver respostas JSON claras.
@RestControllerAdvice
public class ApiExceptionHandler {

    // Livro inexistente: HTTP 404 (Not Found).
    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> tratarLivroNaoEncontrado(LivroNaoEncontradoException erro) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("erro", erro.getMessage()));
    }

    // Dados inválidos, como título ou autor vazio: HTTP 400 (Bad Request).
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarDadosInvalidos(MethodArgumentNotValidException erro) {
        String mensagem = erro.getBindingResult().getFieldErrors().stream()
                .map(campo -> campo.getDefaultMessage())
                .findFirst()
                .orElse("Dados inválidos");

        return ResponseEntity.badRequest().body(Map.of("erro", mensagem));
    }
}
