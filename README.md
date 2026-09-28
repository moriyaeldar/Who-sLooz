# Who's Looz

A Java **Spring Boot** REST service for managing a shared schedule ("looz", לו״ז): who is assigned to which days. It is backed by **MongoDB** through Spring Data repositories.

## Tech stack

- **Java 19**, **Spring Boot 2.7**
- **Spring Data MongoDB** (`MongoRepository`, derived queries and `@Query`)
- **Spring Cloud Gateway** / WebFlux dependencies
- Maven (wrapper included)

## API

Base path: `/api`

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/looz` | List all schedule items (`204` when empty) |
| `GET` | `/looz/{id}` | Get one item (`404` if missing) |
| `POST` | `/looz` | Create an item: `{ "id", "name", "days" }` |
| `PUT` | `/looz/{id}` | Update an item |
| `DELETE` | `/looz/{id}` | Delete an item |

Layers: `controllers/` (REST + `ResponseEntity` status handling) → `repositories/` (Spring Data) → `entities/` (`@Document("looz")`).

## Running locally

```bash
export MONGODB_URI=mongodb://localhost:27017   # default if unset
./mvnw spring-boot:run
```
