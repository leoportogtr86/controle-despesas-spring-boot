# Controle de Despesas

Este é um projeto de Controle de Despesas desenvolvido com Java e Spring Boot. A aplicação permite registrar,
categorizar despesas e gerar relatórios financeiros através de uma API RESTful.

## Funcionalidades

- Adicionar uma nova despesa
- Listar todas as despesas
- Atualizar uma despesa existente
- Deletar uma despesa
- Gerar relatórios por categoria
- Calcular o total de despesas

## Tecnologias Utilizadas

- Java 11
- Spring Boot 2.6
- Spring Data JPA
- H2 Database

## Configuração do Projeto

### Pré-requisitos

- Java 11 ou superior instalado
- Maven instalado

### Passo a Passo

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/leoportogtr86/controle-despesas-spring-boot.git
   cd controle-despesas-spring-boot
   ```

2. **Configuração do banco de dados:**

   O projeto está configurado para usar o banco de dados H2 em memória. A configuração pode ser encontrada no
   arquivo `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Execute a aplicação:**

   ```bash
   mvn spring-boot:run
   ```

4. **Acesse o console do H2:**

   O console do H2 pode ser acessado em `http://localhost:8080/h2-console`. Use as seguintes credenciais:

    - **JDBC URL:** `jdbc:h2:mem:testdb`
    - **User Name:** `sa`
    - **Password:** `password`

## Endpoints da API

### Listar todas as despesas

- **URL:** `/api/expenses`
- **Método:** `GET`
- **Resposta:** Lista de despesas

  ```json
  [
      {
          "id": 1,
          "description": "Compra de supermercado",
          "amount": 150.0,
          "category": "Alimentação",
          "date": "2024-07-01"
      },
      ...
  ]
  ```

### Adicionar uma nova despesa

- **URL:** `/api/expenses`
- **Método:** `POST`
- **Corpo da Requisição:**

  ```json
  {
      "description": "Compra de supermercado",
      "amount": 150.0,
      "category": "Alimentação",
      "date": "2024-07-01"
  }
  ```

- **Resposta:** Despesa criada

  ```json
  {
      "id": 1,
      "description": "Compra de supermercado",
      "amount": 150.0,
      "category": "Alimentação",
      "date": "2024-07-01"
  }
  ```

### Atualizar uma despesa existente

- **URL:** `/api/expenses/{id}`
- **Método:** `PUT`
- **Corpo da Requisição:**

  ```json
  {
      "description": "Compra de supermercado",
      "amount": 180.0,
      "category": "Alimentação",
      "date": "2024-07-01"
  }
  ```

- **Resposta:** Despesa atualizada

  ```json
  {
      "id": 1,
      "description": "Compra de supermercado",
      "amount": 180.0,
      "category": "Alimentação",
      "date": "2024-07-01"
  }
  ```

### Deletar uma despesa

- **URL:** `/api/expenses/{id}`
- **Método:** `DELETE`
- **Resposta:** Código de status 204 (No Content)

### Relatórios por categoria

- **URL:** `/api/expenses/category/{category}`
- **Método:** `GET`
- **Resposta:** Lista de despesas da categoria especificada

  ```json
  [
      {
          "id": 1,
          "description": "Compra de supermercado",
          "amount": 150.0,
          "category": "Alimentação",
          "date": "2024-07-01"
      },
      ...
  ]
  ```

### Total de despesas

- **URL:** `/api/expenses/total`
- **Método:** `GET`
- **Resposta:** Total de despesas

  ```json
  1500.0
  ```

## Estrutura do Projeto

```plaintext
src
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── expensemanager
│   │               ├── ExpenseManagerApplication.java
│   │               ├── controller
│   │               │   └── ExpenseController.java
│   │               ├── model
│   │               │   └── Expense.java
│   │               ├── repository
│   │               │   └── ExpenseRepository.java
│   │               └── service
│   │                   └── ExpenseService.java
│   └── resources
│       ├── application.properties
│       └── data.sql
└── test
    └── java
        └── com
            └── example
                └── expensemanager
                    └── ExpenseManagerApplicationTests.java
```
