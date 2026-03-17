# TinyURL - URL Shortener

A simple URL shortener built with **Spring Boot** and **PostgreSQL**.  
It allows users to generate short links for long URLs and track how many times they were accessed.

---

## Features

- Generate short URLs
- Redirect to the original URL
- Track click counts
- View statistics for each shortened URL
- REST API built with Spring Boot

---

## Tech Stack

Backend:
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok

Tools:
- Maven
- Docker (for PostgreSQL)

Frontend (optional):
- HTML
- CSS
- JavaScript

---

## Project Structure


src
├── controller
├── service
├── repository
├── entities
├── dto
└── Application.java


---

## Setup

### 1. Clone the repository

```
git clone https://github.com/yourusername/tinyurl.git
cd tinyurl
```
### 2. Start PostgreSQL with Docker
```
docker compose up -d
```
### 3. Configure application.properties
```
spring.datasource.url=jdbc:postgresql://localhost:5432/tinyurl
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
### 4. Run the application

Using Maven:

`./mvnw spring-boot:run`

or run the main class in your IDE.

Server will start at:

http://localhost:8080
API Endpoints
Create Short URL
POST /shorten

Request body:
```
{
  "url": "https://example.com"
}
```

Response:

http://localhost:8080/abc123
Redirect to Original URL
GET /{code}

Example:

GET /abc123

Redirects to the original URL.

Get URL Statistics
GET /stats/{code}

Response:
```
{
  "url": "https://example.com",
  "clicks": 5,
  "createdAt": "2026-03-16T20:00:00"
}
```
## Future Improvements

### Possible features to add:

- Custom short codes

- Link expiration

- Analytics dashboard

- Rate limiting

- Redis caching

## License

This project is open source and available under the MIT License.
