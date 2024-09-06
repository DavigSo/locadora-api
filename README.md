Mais um exercício do curso Spring boot e Angular.js - Wellington de oliveira, dessa vez o objetivo era fazer uma aplicação com Spring Data Jpa com Banco de dados MySql

Claro! Aqui está o trecho que você forneceu em texto:

---

# Locadora API

Uma aplicação de CRUD para uma locadora de filmes, desenvolvida com Spring Boot e Spring Data JPA, usando MySQL como banco de dados.

## Funcionalidades

- **Criar** um novo filme.
- **Listar** todos os filmes.
- **Buscar** um filme por ID.
- **Atualizar** as informações de um filme existente.
- **Deletar** um filme.

## Tecnologias

- **Spring Boot**: Framework para construção de aplicações Java.
- **Spring Data JPA**: Facilita a manipulação de dados com JPA.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional.
- **Lombok**: Biblioteca para reduzir o código boilerplate.

## Pré-requisitos

- Java 17 ou superior
- Maven
- MySQL

## Configuração do Banco de Dados

Certifique-se de que o MySQL está instalado e rodando. Crie um banco de dados chamado `locadora` e ajuste as configurações no arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/locadora
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```

---

## Rodando a Aplicação

1. **Clone o Repositório:**

   ```bash
   git clone https://github.com/SeuUsuario/locadora-api.git
   cd locadora-api
   ```

2. **Compile e Execute a Aplicação:**

   ```bash
   mvn spring-boot:run
   ```

   Ou, se preferir, use um IDE (como IntelliJ IDEA ou Eclipse) para rodar a aplicação.

## Endpoints

- **POST** `/api/filmes`: Cria um novo filme.
- **GET** `/api/filmes`: Lista todos os filmes.
- **GET** `/api/filmes/{id}`: Busca um filme por ID.
- **PUT** `/api/filmes/{id}`: Atualiza um filme existente.
- **DELETE** `/api/filmes/{id}`: Deleta um filme.

## Exemplos de Requisições

### Criar Filme

```http
POST /api/filmes
Content-Type: application/json

{
  "titulo": "O Senhor dos Anéis",
  "diretor": "Peter Jackson",
  "ano": 2001,
  "genero": "Fantasia"
}
```

### Listar Filmes

```http
GET /api/filmes
```

### Buscar Filme por ID

```http
GET /api/filmes/1
```

### Atualizar Filme

```http
PUT /api/filmes/1
Content-Type: application/json

{
  "titulo": "O Senhor dos Anéis: As Duas Torres",
  "diretor": "Peter Jackson",
  "ano": 2002,
  "genero": "Fantasia"
}
```

### Deletar Filme

```http
DELETE /api/filmes/1
```
