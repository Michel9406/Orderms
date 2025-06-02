# 🧠 Sistema de Processamento e Consulta de Pedidos

Imagine um restaurante movimentado ou uma loja online com muitos pedidos chegando a todo momento. Esse projeto foi desenvolvido para organizar, processar e armazenar essas solicitações de maneira eficiente, confiável e escalável.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **RabbitMQ**
- **MongoDB**
- **Docker**
- **API RESTful**

## ⚙️ Como Funciona

### 1. Recepção Organizada
Os pedidos entram em uma fila digital organizada utilizando **RabbitMQ**, como se cada pedido pegasse uma senha e aguardasse sua vez.

### 2. Processamento Inteligente
Uma aplicação em **Java com Spring Boot** atua como o "cérebro" do sistema. Ela consome as mensagens da fila, interpreta os dados do pedido e os prepara para armazenamento.

### 3. Armazenamento Flexível
As informações são salvas no **MongoDB**, um banco de dados NoSQL ideal para armazenar dados não estruturados ou semiformatados, com facilidade de escalabilidade.

### 4. Isolamento com Docker
Cada parte do sistema (fila, aplicação, banco de dados) roda em seu próprio container via **Docker**, facilitando o deploy e a manutenção.

### 5. API REST
Criamos uma API para facilitar a consulta de dados, com endpoints como:

- `GET /pedidos/cliente/{id}` → Histórico de pedidos por cliente  
- `GET /pedidos/{id}` → Detalhes de um pedido específico  
- `GET /pedidos/cliente/{id}/quantidade` → Total de pedidos realizados  
- `GET /pedidos/{id}/valor` → Valor total de um pedido



  
📌 Objetivo
Esse projeto demonstra como utilizar mensageria, microsserviços e banco de dados NoSQL para construir sistemas eficientes, desacoplados e prontos para alto volume de dados.



👨‍💻 Autor
Desenvolvido por Michel 🚀

Este projeto faz parte de uma jornada de aprendizado em arquitetura de sistemas, mensageria e microsserviços. Fique à vontade para abrir issues ou contribuir!

## 📦 Como Executar Localmente

1. Clone este repositório:

```bash
git clone[ https://github.com/
](https://github.com/Michel9406/Orderms/tree/main)

Navegue até a pasta do projeto e suba os containers com Docker Compose:

cd nome-do-repositorio orderms
docker-compose up --build
Acesse a API via http://localhost:8080

