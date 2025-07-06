# Library Management Spring Boot Application

This is a complete Spring Boot application for managing a library system with CRUD operations for books.

## Features

- **Spring Boot 3.2.5** with Java 17
- **Spring Data JPA** for database operations
- **H2 Database** for in-memory storage
- **RESTful API** endpoints for book management
- **Web interface** for testing the API

## Project Structure

```
src/
├── main/
│   ├── java/com/example/librarymanagement/
│   │   ├── LibraryManagementApplication.java    # Main Spring Boot application
│   │   ├── controller/
│   │   │   └── BookController.java             # REST controller for book operations
│   │   ├── entity/
│   │   │   └── Book.java                      # Book entity class
│   │   └── repository/
│   │       └── BookRepository.java             # JPA repository interface
│   └── resources/
│       ├── application.properties              # Database and application configuration
│       └── static/
│           └── index.html                      # Web interface for testing
```

## Dependencies

- **Spring Boot Starter Web**: For REST API and web functionality
- **Spring Boot Starter Data JPA**: For database operations
- **H2 Database**: In-memory database for development
- **Jakarta Persistence API**: For JPA annotations

## Configuration

The application is configured with:
- H2 in-memory database
- JPA with Hibernate
- H2 console enabled at `/h2-console`
- Auto table creation (`spring.jpa.hibernate.ddl-auto=update`)

## Running the Application

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Steps to Run

1. **Navigate to the project directory:**
   ```bash
   cd LibraryManagementSpringBoot
   ```

2. **Run the application using Maven:**
   ```bash
   mvn spring-boot:run
   ```

3. **Or build and run:**
   ```bash
   mvn clean package
   java -jar target/LibraryManagementSpringBoot-1.0-SNAPSHOT.jar
   ```

The application will start on `http://localhost:8080`

## Testing the Application

### Web Interface
1. Open your browser and go to `http://localhost:8080`
2. Use the web interface to:
   - Add new books
   - View all books
   - Search books by ID or author
   - Delete books

### REST API Endpoints

#### 1. Get All Books
```bash
GET http://localhost:8080/api/books
```

#### 2. Get Book by ID
```bash
GET http://localhost:8080/api/books/{id}
```

#### 3. Create New Book
```bash
POST http://localhost:8080/api/books
Content-Type: application/json

{
    "title": "The Great Gatsby",
    "author": "F. Scott Fitzgerald"
}
```

#### 4. Update Book
```bash
PUT http://localhost:8080/api/books/{id}
Content-Type: application/json

{
    "title": "Updated Title",
    "author": "Updated Author"
}
```

#### 5. Delete Book
```bash
DELETE http://localhost:8080/api/books/{id}
```

#### 6. Get Books by Author
```bash
GET http://localhost:8080/api/books/author/{authorName}
```

### H2 Database Console
1. Open your browser and go to `http://localhost:8080/h2-console`
2. Use these connection details:
   - **JDBC URL**: `jdbc:h2:mem:librarydb`
   - **Username**: `sa`
   - **Password**: (leave empty)
3. Click "Connect" to view the database tables and data

## Example API Usage with curl

### Add a book:
```bash
curl -X POST http://localhost:8080/api/books \
  -H "Content-Type: application/json" \
  -d '{"title":"To Kill a Mockingbird","author":"Harper Lee"}'
```

### Get all books:
```bash
curl http://localhost:8080/api/books
```

### Get book by ID:
```bash
curl http://localhost:8080/api/books/1
```

### Update a book:
```bash
curl -X PUT http://localhost:8080/api/books/1 \
  -H "Content-Type: application/json" \
  -d '{"title":"Updated Title","author":"Updated Author"}'
```

### Delete a book:
```bash
curl -X DELETE http://localhost:8080/api/books/1
```

## Features Implemented

✅ **Spring Boot Project Structure**
- Main application class with `@SpringBootApplication`
- Proper package structure

✅ **Dependencies**
- Spring Web for REST API
- Spring Data JPA for database operations
- H2 Database for in-memory storage

✅ **Application Properties**
- Database connection configuration
- JPA and Hibernate settings
- H2 console enabled

✅ **Entities and Repositories**
- Book entity with JPA annotations
- BookRepository interface extending JpaRepository

✅ **REST Controller**
- Complete CRUD operations
- Proper HTTP status codes
- Error handling
- Additional search functionality

✅ **Application Running**
- Spring Boot application starts successfully
- All endpoints accessible
- Web interface for testing

## Troubleshooting

1. **Port already in use**: Change the port in `application.properties`:
   ```
   server.port=8081
   ```

2. **Database issues**: The H2 database is in-memory, so data will be lost when the application stops. For persistence, consider using a file-based H2 database or MySQL/PostgreSQL.

3. **CORS issues**: The controller has `@CrossOrigin(origins = "*")` to allow cross-origin requests.

## Next Steps

To enhance this application, consider:
- Adding more entities (Author, Category, etc.)
- Implementing user authentication
- Adding validation and error handling
- Using a persistent database like MySQL or PostgreSQL
- Adding unit and integration tests
- Implementing pagination for large datasets 