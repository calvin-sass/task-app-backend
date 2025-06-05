# Tasks – Task Tracking App

A Spring Boot application for managing task lists and tasks, supporting PostgreSQL and H2 databases. This project provides a RESTful API for creating, updating, and retrieving task lists and their associated tasks.

## Features
- Create and manage multiple task lists
- Add, update, and retrieve tasks within a list
- RESTful API endpoints
- Uses Spring Boot, Spring Data JPA, and PostgreSQL
- Docker support

## API Endpoints

### Task Lists
- `GET /api/task-lists` – List all task lists
- `POST /api/task-lists` – Create a new task list
- `GET /api/task-lists/{task_list_id}` – Get a specific task list
- `PUT /api/task-lists/{task_list_id}` – Update a task list

### Tasks
- `GET /api/task-lists/{task_list_id}/tasks` – List tasks in a task list
- `POST /api/task-lists/{task_list_id}/tasks` – Add a new task to a task list
- `GET /api/task-lists/{task_list_id}/tasks/{task_id}` – Get a specific task
- `PUT /api/task-lists/{task_list_id}/tasks/{task_id}` – Update a task

## Getting Started

### Prerequisites
- Java 21
- Maven
- PostgreSQL (for production)
- Docker (optional, for containerized deployment)

### Running Locally
1. **Clone the repository:**
   ```bash
   git clone <this-repo-url>
   cd tasks
   ```
2. **Set environment variables** for your database connection (see `src/main/resources/application.properties`):
   - `SPRING_DATASOURCE_DRIVER`
   - `SPRING_DATASOURCE_URL`
   - `SPRING_DATASOURCE_USERNAME`
   - `SPRING_DATASOURCE_PASSWORD`
3. **Run with Maven:**
   ```bash
   ./mvnw spring-boot:run
   ```
   Or with Docker:
   ```bash
   docker build -t tasks-app .
   docker run -e SPRING_DATASOURCE_DRIVER=org.postgresql.Driver \
              -e SPRING_DATASOURCE_URL=jdbc:postgresql://<host>:<port>/<db> \
              -e SPRING_DATASOURCE_USERNAME=<username> \
              -e SPRING_DATASOURCE_PASSWORD=<password> \
              -p 8080:8080 tasks-app
   ```

## Project Structure
- `src/main/java/com/springdev/tasks/controllers` – REST controllers
- `src/main/java/com/springdev/tasks/domain` – DTOs and entities
- `src/main/java/com/springdev/tasks/services` – Business logic
- `src/main/java/com/springdev/tasks/repositories` – JPA repositories
- `src/main/resources` – Configuration files

## License
MIT (add your license details here)

---

*Generated on 2025-06-05 by Cascade AI.*
