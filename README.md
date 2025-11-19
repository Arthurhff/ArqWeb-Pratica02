## 📝 CRUD com Spring Boot MVC, Lista em Memória e H2 + JPA

Este projeto é uma aplicação web desenvolvida com **Spring Boot** que implementa operações de **CRUD (Create, Read, Update, Delete)** em uma entidade central. Ele utiliza o padrão arquitetural **MVC (Model-View-Controller)** e integra diferentes mecanismos de persistência.

---

### 🎯 Objetivo do Projeto

O objetivo principal é construir uma aplicação robusta que gerencia dados, demonstrando a transição de um armazenamento em memória (para prototipagem rápida) para uma solução de persistência completa utilizando **JPA (Java Persistence API)** e o banco de dados **H2**.

### 🛠️ Tecnologias e Dependências

O projeto utiliza o ecossistema Spring Boot com as seguintes dependências essenciais:

* **Spring Web:** Para construir a aplicação web e expor a API REST.
* **Spring DevTools:** Para facilitar o desenvolvimento com *live reload*.
* **Spring Data JPA:** Para facilitar a implementação do CRUD e a interação com o banco de dados.
* **H2 Database:** Utilizado como banco de dados em memória, ideal para desenvolvimento e testes.

### 🏛️ Arquitetura e Estrutura

A aplicação segue o padrão **MVC (Model-View-Controller)**:

* **Model:** Representa a entidade de dados (objeto Java) e a lógica de negócios.
* **View:** (Implícita/Opcional) Poderia ser implementada com Thymeleaf ou similar, mas o foco inicial é a API.
* **Controller:** Responsável por manipular as requisições (endpoints) e coordenar o acesso aos dados.

### 🔁 Fases de Persistência

O desenvolvimento do CRUD deve contemplar duas fases distintas de persistência:

1.  **Lista em Memória (Início):**
    * A camada de serviço (Service) ou repositório inicial utiliza uma estrutura de dados simples (como `ArrayList`) para armazenar os dados.
    * Permite testar os endpoints e a lógica de Controller rapidamente.
2.  **H2 Database com JPA (Fase Final):**
    * Substituição do armazenamento em memória por um repositório gerenciado pelo **Spring Data JPA**.
    * Os dados são persistidos no banco de dados H2 (configurado para rodar em memória por padrão), garantindo operações ACID.

### 🌐 Endpoints (API REST)

A aplicação deve expor uma **API REST** através de endpoints (e.g., `/api/minha-entidade`) para realizar todas as operações do CRUD:

| Operação | Método HTTP | Rota de Exemplo | Descrição |
| :--- | :--- | :--- | :--- |
| **Criar** | `POST` | `/api/minha-entidade` | Adiciona um novo registro. |
| **Listar Todos** | `GET` | `/api/minha-entidade` | Retorna todos os registros. |
| **Buscar por ID** | `GET` | `/api/minha-entidade/{id}` | Retorna um registro específico. |
| **Atualizar** | `PUT` | `/api/minha-entidade/{id}` | Atualiza um registro existente. |
| **Deletar** | `DELETE` | `/api/minha-entidade/{id}` | Remove um registro. |

---
**Arthur Fernandes**
