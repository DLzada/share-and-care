# Share and Care API

[![Java](https://img.shields.io/badge/Java-21%2B-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.6-brightgreen)](https://spring.io/projects/spring-boot)
[![Security](https://img.shields.io/badge/Security-JWT-blue)](https://jwt.io/)

O **Share and Care** é uma API REST desenvolvida para gerenciar doações e estoques de itens essenciais. O foco principal do projeto foi aplicar padrões de arquitetura corporativa modernos, segurança avançada com JWT e persistência robusta utilizando as tecnologias mais recentes do ecossistema Java.

## Tecnologias Utilizadas

*   **Linguagem:** Java 21 (LTS)
*   **Framework:** Spring Boot 4.0.6
*   **Segurança:** Spring Security + JWT (JSON Web Token)
*   **Persistência:** Spring Data JPA + Hibernate
*   **Banco de Dados:** PostgreSQL
*   **Auxiliares:** Lombok, Maven, Bean Validation

## ️ Funcionalidades de Segurança

Este projeto implementa uma infraestrutura de segurança moderna frequentemente utilizadas em APIs REST:

*   **Autenticação Stateless:** A API utiliza Tokens JWT para validar cada requisição, garantindo escalabilidade e eliminando a necessidade de sessões no servidor.
*   **Criptografia BCrypt:** Todas as senhas de usuários passam por um processo de hashing com Salt antes de serem persistidas no banco de dados.
*   **Segurança por Filtros:** Implementação de `SecurityFilter` personalizado para interceptar e validar de forma eficiente o cabeçalho `Authorization`.

## Arquitetura do Projeto

O projeto foi estruturado seguindo o padrão de camadas para garantir a separação de responsabilidades e facilidade de manutenção:

1.  **Controller:** Gerencia as rotas e a comunicação HTTP.
2.  **Service:** Contém as regras de negócio e lógica da aplicação.
3.  **Repository:** Interface de comunicação com o PostgreSQL.
4.  **Domain/Entity:** Mapeamento das tabelas do banco de dados.
5.  **DTO (Data Transfer Object):** Garante a segurança e a integridade dos dados trafegados entre as camadas.

## Endpoints da API
A API está dividida em rotas públicas para autenticação e rotas protegidas que exigem um Token JWT válido enviado no cabeçalho Authorization.

1. **Endpoints de Acesso Público** - Estes endpoints não exigem autenticação.
    <table>
            <thead>
                <tr>
                    <th>Método</th>
                    <th>Endpoint</th>
                    <th>Descrição</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>POST</td>
                    <td><code>/usuarios</code></td>
                    <td>Realiza o cadastro de um novo usuário. A senha é criptografada com BCrypt.</td>
                </tr>
                <tr>
                    <td>POST</td>
                    <td><code>/login</code></td>
                    <td>Autentica o usuário e retorna o Token JWT para acesso às demais rotas.</td>
                </tr>
            </tbody>
   </table>

2. **Endpoints Principais (Protegidos)** - Endpoints fundamentais para a operação do sistema Share and Care.

    <table>
        <thead>
            <tr>
                <th>Método</th>
                <th>Endpoint</th>
                <th>Descrição</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>GET</td>
                <td><code>/estoques</code></td>
                <td>Lista todos os itens disponíveis no estoque.</td>
            </tr>
            <tr>
                <td>POST</td>
                <td><code>/doadores</code></td>
                <td>Realiza o cadastro de um novo doador.</td>
            </tr>
            <tr>
                <td>GET</td>
                <td><code>/doadores</code></td>
                <td>Retornar a lista de doadores cadastrados</td>
            </tr>
        </tbody>
    </table>
   
3. **Endpoints de Gerenciamento (CRUD)** - Endpoints adicionais para manutenção e controle detalhado dos recursos. Exigem Token JWT.

* **Gerenciamento de Itens/Estoque:**
    <table>
        <thead>
            <tr>
                <th>Método</th>
                <th>Endpoint</th>
                <th>Descrição</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>GET</td>
                <td><code>/estoques/{id}</code></td>
                <td>Busca detalhes de um item específico por ID.</td>
            </tr>
            <tr>
                <td>PUT</td>
                <td><code>/estoques/{id}</code></td>
                <td>Atualiza informações de um item existente (ex: quantidade, nome).</td>
            </tr>
            <tr>
                <td>DELETE</td>
                <td><code>/estoques/{id}</code></td>
                <td>Remove um item do estoque.</td>
            </tr>
        </tbody>
    </table>

* **Gerenciamento de Doadores:**
<table>
        <thead>
            <tr>
                <th>Método</th>
                <th>Endpoint</th>
                <th>Descrição</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>GET</td>
                <td><code>/doadores/{id}</code></td>
                <td>Busca um doador específico pelo ID.</td>
            </tr>
            <tr>
                <td>PUT</td>
                <td><code>/doadores/{id}</code></td>
                <td>Atualiza os dados de contato ou endereço de um doador.</td>
            </tr>
            <tr>
                <td>DELETE</td>
                <td><code>/doadores/{id}</code></td>
                <td>Remove um doador do sistema.</td>
            </tr>
        </tbody>
    </table>

> **Informações sobre as requisições:**
Para todos os endpoints das categorias 2 e 3, a requisição deve obrigatoriamente conter o cabeçalho de autorização:

**Header:** `Authorization: Bearer <seu_token_jwt_aqui>`

**Exemplo de Corpo de Requisição (JSON)** para `/usuarios` e `/login`:
```json
{
    "login": "usuario",
    "senha": "123"
}
```