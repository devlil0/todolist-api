# 📝 ToDo List API

🌎 Idioma:
- 🇧🇷 Português (este arquivo)
- 🇺🇸 [English](README.md)

---

## 📌 Descrição

API RESTful para gerenciamento de tarefas, desenvolvida com Spring Boot, PostgreSQL e Docker.

---

## 🚀 Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Maven

---

## ⚙️ Configuração

### application.yml

```yaml
server:
  port: 8082

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/todolist_db
    username: postgres
    password: postgres

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

## 🐳 Docker

```bash
docker compose up -d
```

---

## ▶️ Execução

```bash
mvn spring-boot:run
```

API: http://localhost:8082

---

## 📌 Endpoints

- POST /tasks
- GET /tasks
- GET /tasks/{id}
- DELETE /tasks/{id}

---

## ⚠️ Observações

- IDs não são reutilizados após delete
- Utilize DTOs (não exponha entidades)

---

## 👨‍💻 Autor

https://github.com/devlil0
