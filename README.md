# Book-Manager-SpringBoot

A simple backend-only CRUD application for managing books using Spring Boot and H2 in-memory database. This project demonstrates REST API development with proper endpoint handling and uses standard Spring Boot practices.

## Features

- Add new books
- Get all books
- Get a book by ID
- Update book details
- Delete a book by ID

## Tools & Technologies

- **Framework:** Spring Boot
- **Database:** H2 In-Memory DB
- **Dependencies:** 
  - Spring Web
  - Spring Data JPA
  - Lombok
  - H2 Database
- **Testing Tool:** Postman
- **IDE:** IntelliJ IDEA

## Project Structure

- **Main Package:** `com.codewithmoksh.CRUD_App`
- **Controllers:** Handles CRUD endpoints.
- **Model:** Represents the Book entity.
- **Repository:** Interface for database operations.

## Getting Started

### Prerequisites

- Java 17+ installed
- Maven installed

### Run with IntelliJ IDEA

1. Clone the repository
2. Open project in IntelliJ IDEA
3. Let Maven resolve dependencies
4. Run the application using `CRUDAPPApplication.java`

### Run via Maven

```bash
mvn spring-boot:run
```
## Base URL
```bash
https://localhost:9090/
```

## 📡 API Endpoints

| Method | Endpoint                  | Description                        |
|--------|---------------------------|------------------------------------|
| GET    | `/getAllBooks`           | Fetch all books from the database  |
| GET    | `/getBookById/{id}`      | Fetch a specific book by ID        |
| POST   | `/addBook`               | Add a new book                     |
| PUT    | `/updateBookById/{id}`   | Update an existing book by ID      |
| DELETE | `/deleteBookById/{id}`   | Delete a book by ID                |


> 🛠️ [A Moksh Production](https://github.com/codewithmoksh) – from chaos to clarity, transforming logic into legacy.
