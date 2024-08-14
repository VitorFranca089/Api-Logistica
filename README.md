# 🚚 API logística 🚚

Bem-vindo(a) ao meu repositório! Este projeto é uma API que simula um sistema logístico, desenvolvida com Spring Boot.

## 📖 Sobre o projeto

O projeto se trata de uma API que faz o gerenciamento logístico de entregas, onde é possível manipular e rastrear entregas juntamente com uma cobertura de segurança de acesso, utilizando Spring Boot, banco de dados SQL, Spring Security e o consumo da API ViaCep para o registro e consulta automáticos de endereços.

## ✔️ Funcionalidades do projeto

- **Gestão de Entregas:** Criação, atualização, visualização e cancelamento de entregas.
- **Rastreamento de Entregas:** Registro e consulta de pontos de rastreio ao longo do processo de entrega.
- **Gerenciamento de Usuários:** Criação e administração de diferentes tipos de usuários (cliente, funcionário e administrador) com permissões específicas.
- **Autenticação de Usuários:** Registro e login de usuários com controle de acesso baseado em "roles".
- **Integração com API Externa:** Consulta e registro automático de endereços a partir de CEPs utilizando a API ViaCep.

## ⚙️ Tecnologias utilizadas

- Java 21.
- Spring Boot.
- Maven.
- Banco de Dados SQL (H2 database).

## 💻 Pré-requisitos

Certifique-se que esteja instalado:

- Java JDK 21.
- Maven.

## 🌐 Execução do projeto

1. Clone este repositório:
``` bash
git clone https://github.com/VitorFranca089/Api-Logistica.git
```
2. Navegue até o diretório do projeto:
``` bash
cd <diretório-do-projeto>
```
3. Instale as dependências do Maven:
``` bash
mvn clean install
```
4. Execute a aplicação com o comando:
``` bash
mvn spring-boot:run
```

## 📋 Endpoints da API

#### Entregas

- `POST /api/entregas/cadastro` - Registra uma nova entrega. (Funcionario/Admin)
- `GET /api/entregas/{id}` - Retorna os detalhes de uma entrega específica.
- `GET /api/entregas` - Retorna a lista de todas as entregas registradas. (Funcionario/Admin)
- `PATCH /api/entregas/{id}/status` - Atualiza o status de uma entrega específica. (Funcionario/Admin)
- `DELETE /api/entregas/{id}` - Deleta uma entrega específica. (Admin)

#### Rastreamentos

- `POST /api/rastreamento/{id}` - Registra um novo ponto de rastreio para uma entrega. (Funcionario/Admin)
- `GET /api/rastreamento/{id}` - Retorna a lista de pontos de rastreio de uma entrega específica.

#### Usuários

- `POST /auth/register` - Registra um novo usuário no sistema.
- `POST /auth/login` - Realiza o login de um usuário.