# 🎮 GameCRM - Sistema de Gestão de Clientes para Loja de Games

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange" />
  <img src="https://img.shields.io/badge/Spring_Boot-3-green" />
  <img src="https://img.shields.io/badge/MySQL-Database-blue" />
  <img src="https://img.shields.io/badge/API-REST-success" />
  <img src="https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow" />
</p>

---

## 📖 Sobre o Projeto

O **GameCRM** é um sistema de gerenciamento de relacionamento com clientes (CRM) desenvolvido para lojas de games.

O objetivo do sistema é centralizar informações de clientes, registrar atendimentos, acompanhar compras e facilitar o relacionamento entre a loja e seus consumidores.

Este projeto foi desenvolvido como parte do **Projeto Integrador do curso Java Full Stack da Generation Brasil**, aplicando conceitos de desenvolvimento Backend com Java e Spring Boot.

---

## 🎯 Objetivos

- Gerenciar clientes da loja
- Registrar atendimentos realizados
- Controlar histórico de compras
- Organizar informações de produtos
- Melhorar o relacionamento com os clientes
- Disponibilizar uma API REST para integração futura com aplicações Frontend

---

## ⚙️ Funcionalidades

### 👤 Clientes

- Cadastrar cliente
- Buscar cliente por ID
- Listar clientes
- Atualizar cadastro
- Excluir cliente

### 🎮 Produtos

- Cadastrar jogos
- Consultar catálogo
- Atualizar informações
- Remover produtos

### 📞 Atendimentos

- Registrar atendimento
- Histórico de interações
- Consultar atendimentos por cliente

### 🛒 Compras

- Registrar compras
- Consultar histórico de compras
- Relacionar cliente e produto

---

## 🗂️ Estrutura do Projeto

```
src/main/java
│
├── controller
├── service
├── repository
├── model
├── dto
├── exception
└── config
```

---

## 🛠️ Tecnologias Utilizadas

### Backend

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- Maven
- Lombok
- Bean Validation

### Banco de Dados

- MySQL

### Ferramentas

- STS (Spring Tool Suite)
- Git
- GitHub
- Insomnia

---

## 🗄️ Modelo de Dados

### Cliente

| Campo | Tipo |
|---------|---------|
| id | Long |
| nome | String |
| email | String |
| telefone | String |
| dataCadastro | LocalDate |

### Produto

| Campo | Tipo |
|---------|---------|
| id | Long |
| nome | String |
| categoria | String |
| preco | BigDecimal |
| estoque | Integer |

### Atendimento

| Campo | Tipo |
|---------|---------|
| id | Long |
| descricao | String |
| data | LocalDate |
| cliente | Cliente |

### Compra

| Campo | Tipo |
|---------|---------|
| id | Long |
| dataCompra | LocalDate |
| valorTotal | BigDecimal |
| cliente | Cliente |

---

## 🔗 Relacionamentos

Cliente → Atendimentos

```text
Cliente
   |
   | 1:N
   |
Atendimento
```

Cliente → Compras

```text
Cliente
   |
   | 1:N
   |
Compra
```

Compra → Produtos

```text
Compra
   |
   | N:N
   |
Produto
```

---

## 🚀 Endpoints Principais

### Clientes

| Método | Endpoint |
|----------|----------|
| GET | /clientes |
| GET | /clientes/{id} |
| POST | /clientes |
| PUT | /clientes |
| DELETE | /clientes/{id} |

### Produtos

| Método | Endpoint |
|----------|----------|
| GET | /produtos |
| POST | /produtos |
| PUT | /produtos |
| DELETE | /produtos/{id} |

### Atendimentos

| Método | Endpoint |
|----------|----------|
| GET | /atendimentos |
| POST | /atendimentos |

---

## ▶️ Como Executar

### Clone o projeto

```bash
git clone https://github.com/SEU-USUARIO/GameCRM.git
```

### Entre na pasta

```bash
cd GameCRM
```

### Configure o banco MySQL

No arquivo:

```properties
src/main/resources/application.properties
```

Configure:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gamecrm
spring.datasource.username=root
spring.datasource.password=suaSenha
```

### Execute a aplicação

Pelo STS:

```text
Run As → Spring Boot App
```

A API estará disponível em:

```text
http://localhost:8080
```

---

## 📚 Aprendizados

Durante o desenvolvimento deste projeto foram aplicados conceitos de:

- Programação Orientada a Objetos
- APIs REST
- CRUD Completo
- Spring Boot
- JPA/Hibernate
- Relacionamentos entre entidades
- Persistência de Dados
- Arquitetura MVC
- Versionamento com Git e GitHub

---

## 👨‍💻 Desenvolvedor

### Fernando Garcia

📧 fernandogarcia98@hotmail.com

💼 LinkedIn:
www.linkedin.com/in/nandogarciadev

🐙 GitHub:
https://github.com/nandogarciadev

---

<p align="center">
  Desenvolvido com ☕ Java e 🎮 paixão por tecnologia.
</p>
