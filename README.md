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