# 📝 ToDo List API

🌎 Language:
- 🇧🇷 [Português](README_pt.md)
- 🇺🇸 English (this file)

---

## 📌 Description

RESTful API for task management built with Spring Boot, PostgreSQL and Docker.

---

## 🚀 Technologies

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Maven

---

## ⚙️ Configuration

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

## ▶️ Run

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

## ⚠️ Notes

- IDs are not reused after deletion
- Use DTOs (do not expose entities)

---

## 👨‍💻 Author

https://github.com/devlil0
