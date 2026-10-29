package br.com.desafio.minhaestante.livro;

import br.com.desafio.minhaestante.exception.LivroNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

// O Service concentra as regras e operações da aplicação.
@Service
public class LivroService {

    private final LivroRepository repository;

    // O Spring entrega o repository pronto para usarmos.
    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    public Livro buscarPorId(Long id) {
        // Se não encontrar o ID, lançamos nossa exceção de livro não encontrado.
        return repository.findById(id)
                .orElseThrow(() -> new LivroNaoEncontradoException(id));
    }

    public Livro criar(LivroRequisicao requisicao) {
        Livro livro = new Livro(requisicao.titulo().trim(), requisicao.autor().trim(), requisicao.lido());
        return repository.save(livro);
    }

    public Livro atualizar(Long id, LivroRequisicao requisicao) {
        Livro livro = buscarPorId(id);
        livro.setTitulo(requisicao.titulo().trim());
        livro.setAutor(requisicao.autor().trim());
        livro.setLido(requisicao.lido());
        return repository.save(livro);
    }

    public Livro marcarComoLido(Long id) {
        Livro livro = buscarPorId(id);
        livro.setLido(true);
        return repository.save(livro);
    }

    public void excluir(Long id) {
        // Primeiro confirmamos que o livro existe, para devolver 404 se não existir.
        Livro livro = buscarPorId(id);
        repository.delete(livro);
    }
}
