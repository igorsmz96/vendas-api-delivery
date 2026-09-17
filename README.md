# 🥾 Andaraki API

API RESTful desenvolvida em **Java + Spring Boot** para o sistema de delivery da **Andaraki**, uma franquia de loja de calçados, bolsas, cintos e meias com 5 unidades físicas.

O projeto simula um modelo de negócio no estilo *iFood*: o cliente pesquisa um produto, o sistema identifica em quais lojas da franquia ele está disponível, seleciona a loja mais próxima do cliente, processa o pagamento online e dispara o pedido para a loja responsável.

> ⚠️ **Status do projeto: em desenvolvimento**
> Este é um projeto real, que nasceu como estudo prático de Java e Spring, mas com a intenção de ser implementado futuramente na empresa em que trabalho. Ainda não está pronto para produção — atualmente estou finalizando a camada de `ProductVariant`, com `Stock`, `Cart` e `Order` como próximos passos.

---

## 📌 Sobre o projeto

A Andaraki já é uma loja física, com PDV próprio. Esta API representa um **canal de delivery separado**, que precisa compartilhar o estoque de produtos com o PDV já existente, mantendo uma visão de estoque tanto **universal** (consolidada da franquia) quanto **individual** (por loja).

O projeto foi pensado tanto como um exercício prático de backend com Java/Spring — aplicando autenticação, tratamento de exceções, DTOs, versionamento de banco com Flyway e modelagem de domínio de e-commerce — quanto como uma solução real, que futuramente pretendo colocar em produção na empresa onde trabalho atualmente.

---

## ✅ O que já está implementado

- **Autenticação JWT stateless** — login gera um token (`Bearer`) válido por 24h, verificado a cada requisição por um filtro customizado (`SecurityFilter`), sem uso de sessão
- **Controle de acesso por roles com hierarquia**: `ADMIN > GESTOR > USER` (quem tem `ADMIN` herda automaticamente as permissões de `GESTOR` e `USER`, via `RoleHierarchy` do Spring Security)
- **Tratamento de exceções centralizado** (`@ControllerAdvice`), com handlers específicos para cada tipo de erro (recurso não encontrado, dados duplicados, credenciais inválidas, erros de validação de campo), retornando sempre um payload de erro padronizado (`ErroResposta`)
- **Flyway** para versionamento e controle das migrations do banco de dados
- **Padrão DTO + Mapper**, com `Request`, `RequestPatch` e `Response` separados por entidade (ex: `ProductRequest`, `ProductResponse`), e validação via Bean Validation (`@Valid`, `@NotNull`, etc.)
- **User** — cadastro público e CRUD completo, com rotas separadas para o admin gerenciar qualquer usuário e para o próprio usuário gerenciar seus dados (`/me`)
- **Address** — CRUD de endereços, com rotas via `ADMIN` (gerenciando o endereço de qualquer usuário) e rotas próprias do usuário logado (`/me/address`)
- **Category** — CRUD completo de categorias de produto
- **Product** — CRUD completo de produtos (calçados, bolsas, cintos, meias), com ativação/desativação e busca por categoria
- **ProductVariant** *(em andamento)* — variações de um produto (tamanho, cor, etc.)
- **Store** — CRUD completo das lojas da franquia, com ativação/desativação

### Regras de negócio já definidas

- Cadastro de usuário sempre cria a conta como `USER`, sem vínculo a loja
- A promoção de um usuário a `GESTOR` (com definição da loja) acontece por um endpoint separado, acessível apenas por `ADMIN`
- O campo de loja fica diretamente na entidade `Usuario` (sem entidade `Funcionario` separada), já que o único propósito do `GESTOR` é filtrar dados por loja

---

## 🔐 Segurança e acesso

- Autenticação via **JWT** (biblioteca `auth0/java-jwt`), token carregando `id`, `nome` e `role` do usuário
- Sessão **stateless** — nenhuma sessão é guardada no servidor, cada requisição é validada pelo token
- Hierarquia de roles configurada via `RoleHierarchy`: `ADMIN > GESTOR > USER`
- Hoje as regras de acesso usam `ADMIN` explicitamente nas rotas de escrita; a role `GESTOR` já está modelada na hierarquia e será usada conforme os endpoints de loja (ex: pedidos por loja) forem implementados

---

## 📡 Endpoints

> Legenda de acesso: 🌐 Público · 🔐 Autenticado (qualquer role) · 👑 ADMIN

### 🔑 Auth

| Método | Rota | Acesso | Descrição |
|---|---|---|---|
| POST | `/auth/login` | 🌐 | Autentica o usuário e retorna o token |

### 👤 Users

| Método | Rota | Acesso | Descrição |
|---|---|---|---|
| POST | `/users` | 🌐 | Cadastra um novo usuário (sempre como `USER`) |
| GET | `/users` | 👑 | Lista todos os usuários |
| GET | `/users/{id}` | 👑 | Busca um usuário por ID |
| PATCH | `/users/{id}` | 👑 | Atualiza parcialmente um usuário |
| DELETE | `/users/{id}` | 👑 | Remove um usuário |
| GET | `/users/me` | 🔐 | Retorna os dados do usuário logado |
| PATCH | `/users` | 🔐 | Atualiza os próprios dados |
| DELETE | `/users` | 🔐 | Remove a própria conta |

### 🏠 Address (gerenciado pelo ADMIN)

| Método | Rota | Acesso | Descrição |
|---|---|---|---|
| POST | `/admin/users/{userId}/address` | 👑 | Cria um endereço para um usuário |
| GET | `/admin/users/{userId}/address` | 👑 | Lista os endereços de um usuário |
| GET | `/admin/users/{userId}/address/{id}` | 👑 | Busca um endereço específico |
| PATCH | `/admin/users/{userId}/address/{id}` | 👑 | Atualiza parcialmente um endereço |
| DELETE | `/admin/users/{userId}/address/{id}` | 👑 | Remove um endereço |

### 🏠 Address (próprio usuário)

| Método | Rota | Acesso | Descrição |
|---|---|---|---|
| POST | `/me/address` | 🔐 | Cria um endereço próprio |
| GET | `/me/address` | 🔐 | Lista os próprios endereços |
| GET | `/me/address/{id}` | 🔐 | Busca um endereço próprio específico |
| PATCH | `/me/address/{id}` | 🔐 | Atualiza parcialmente um endereço próprio |
| DELETE | `/me/address/{id}` | 🔐 | Remove um endereço próprio |

### 🏷️ Category

| Método | Rota | Acesso | Descrição |
|---|---|---|---|
| POST | `/category` | 👑 | Cria uma categoria |
| GET | `/category` | 🌐 | Lista todas as categorias |
| GET | `/category/{id}` | 🌐 | Busca uma categoria por ID |
| PATCH | `/category/{id}` | 👑 | Atualiza parcialmente uma categoria |
| DELETE | `/category/{id}` | 👑 | Remove uma categoria |

### 👟 Product

| Método | Rota | Acesso | Descrição |
|---|---|---|---|
| POST | `/product` | 👑 | Cria um produto |
| GET | `/product` | 🌐 | Lista todos os produtos |
| GET | `/product/{id}` | 🌐 | Busca um produto por ID |
| PATCH | `/product/{id}` | 👑 | Atualiza parcialmente um produto |
| GET | `/product/category/{categoryId}` | 🌐 | Lista produtos de uma categoria |
| DELETE | `/product/{id}` | 👑 | Remove um produto |
| PATCH | `/product/{id}/active` | 👑 | Ativa/desativa um produto |

### 🎨 ProductVariant *(em andamento)*

| Método | Rota | Acesso | Descrição |
|---|---|---|---|
| POST | `/product/{productsId}/variants` | 👑 | Cria uma variação para um produto |
| GET | `/product/{productsId}/variants` | 🌐 | Lista as variações de um produto |

### 🏪 Store

| Método | Rota | Acesso | Descrição |
|---|---|---|---|
| POST | `/store` | 👑 | Cria uma loja |
| GET | `/store` | 🌐 | Lista todas as lojas |
| GET | `/store/{id}` | 🌐 | Busca uma loja por ID |
| PATCH | `/store/{id}` | 👑 | Atualiza parcialmente uma loja |
| DELETE | `/store/{id}` | 👑 | Remove uma loja |
| PATCH | `/store/{id}/active` | 👑 | Ativa/desativa uma loja |

---

## 🚧 Próximos passos

- [ ] Finalizar `ProductVariant`
- [ ] `Stock` — controle de estoque universal (franquia) e individual (por loja)
- [ ] `Cart` e `CartItem` — carrinho de compras do cliente, com itens vinculados às variações de produto e à loja de origem
- [ ] `Order` — geração do pedido a partir do carrinho, após confirmação de pagamento
- [ ] Integração com API de pagamento
- [ ] Lógica de busca da loja mais próxima do cliente
- [ ] Refresh token na autenticação
- [ ] Endpoints de escopo `GESTOR` (ex: pedidos filtrados pela própria loja)
- [ ] Painel administrativo em React, consumindo esta API
- [ ] Front-end do cliente (inicialmente em HTML/CSS, com migração futura para React)

---

## 🛠️ Tecnologias

- **Java**
- **Spring Boot**
- **Spring Security** (com `RoleHierarchy` e `@EnableMethodSecurity`)
- **JWT** (`auth0/java-jwt`)
- **Flyway**
- Banco de dados relacional
- Arquitetura em camadas (Controller, Service, Repository, DTO/Mapper)

---

## 🎯 Objetivo do projeto

Este repositório tem dois propósitos que caminham juntos:

1. **Aprendizado prático** — aplicar na prática conceitos de Java, Spring, autenticação, versionamento de banco e modelagem de um domínio real de e-commerce.
2. **Aplicação real** — servir de base para o sistema de delivery da franquia de calçados onde pretendo implementá-lo futuramente, integrando com o PDV já existente da loja.

---

## 👤 Autor

Projeto desenvolvido como estudo prático de back-end com Java e Spring, com previsão de evolução contínua conforme novas funcionalidades forem implementadas.
