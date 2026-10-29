package br.com.desafio.minhaestante.livro;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

// Controller recebe as requisições HTTP e devolve as respostas da API.
@RestController
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    // GET /api/livros: lista todos os livros.
    @GetMapping
    public List<Livro> listarTodos() {
        return service.listarTodos();
    }

    // GET /api/livros/1: procura um livro pelo ID.
    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // POST /api/livros: cria um livro e devolve status 201 (Created).
    @PostMapping
    public ResponseEntity<Livro> criar(@Valid @RequestBody LivroRequisicao requisicao) {
        Livro salvo = service.criar(requisicao);
        URI endereco = URI.create("/api/livros/" + salvo.getId());
        return ResponseEntity.created(endereco).body(salvo);
    }

    // PUT /api/livros/1: atualiza os dados do livro.
    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @Valid @RequestBody LivroRequisicao requisicao) {
        return service.atualizar(id, requisicao);
    }

    // PATCH /api/livros/1/lido: marca o livro como lido.
    @PatchMapping("/{id}/lido")
    public Livro marcarComoLido(@PathVariable Long id) {
        return service.marcarComoLido(id);
    }

    // DELETE /api/livros/1: exclui o livro e devolve status 204 (No Content).
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
