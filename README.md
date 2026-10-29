# Minha Estante — API REST de Livros

Projeto individual de API REST usando Java 21, Spring Boot, Spring Data JPA e banco H2 em memória.

## Requisitos
- Java 21
- Maven Wrapper incluído no projeto

## Executar no Windows
Abra o terminal na pasta do projeto e rode:

```powershell
.\mvnw.cmd clean compile
.\mvnw.cmd spring-boot:run
```

A API ficará em `http://localhost:8080`.

## Endpoints
| Método | Caminho | Função | Resposta esperada |
|---|---|---|---|
| GET | `/api/livros` | Listar livros | 200 OK |
| GET | `/api/livros/{id}` | Buscar livro por ID | 200 OK ou 404 Not Found |
| POST | `/api/livros` | Criar livro | 201 Created |
| PUT | `/api/livros/{id}` | Atualizar todos os dados do livro | 200 OK ou 404 Not Found |
| PATCH | `/api/livros/{id}/lido` | Marcar livro como lido | 200 OK ou 404 Not Found |
| DELETE | `/api/livros/{id}` | Excluir livro | 204 No Content ou 404 Not Found |

## Exemplo de JSON para POST e PUT
```json
{
  "titulo": "O Hobbit",
  "autor": "J. R. R. Tolkien",
  "lido": false
}
```

Título e autor não podem estar vazios. Se algum deles estiver vazio ou contiver apenas espaços, a API devolve 400 Bad Request.

## Console H2
Com a aplicação rodando, abra `http://localhost:8080/h2-console` e use:
- JDBC URL: `jdbc:h2:mem:estante`
- User Name: `sa`
- Password: deixe vazio

O banco é em memória: os dados são apagados quando a aplicação é encerrada.

## Testes básicos no Postman
1. `GET http://localhost:8080/api/livros` — deve retornar `200` e uma lista vazia no início.
2. `POST http://localhost:8080/api/livros` com o JSON de exemplo — deve retornar `201`.
3. `GET http://localhost:8080/api/livros` — deve mostrar o livro criado.
4. `GET http://localhost:8080/api/livros/1` — use o ID que veio na resposta do POST.
5. `PUT http://localhost:8080/api/livros/1` com um JSON atualizado — deve retornar `200`.
6. `PATCH http://localhost:8080/api/livros/1/lido` sem body — deve retornar `200` e `lido: true`.
7. Envie um POST com `"titulo": " "` — deve retornar `400`.
8. `DELETE http://localhost:8080/api/livros/1` — deve retornar `204`.
9. Consulte o ID excluído — deve retornar `404`.

Observação: os IDs são gerados pelo banco; use sempre o ID real devolvido pela API, não presuma que será 1 se já criou outros livros.
