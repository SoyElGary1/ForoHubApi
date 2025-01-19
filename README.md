# ForoHub API - Aplicación de Foro

## Resumen
ForoHub API es un servicio web RESTful diseñado para gestionar temas de foro ("topicos") y proporcionar autenticación de usuarios utilizando Spring Security y Auth0. La aplicación permite a los usuarios:

- Crear, leer, actualizar y eliminar (CRUD) temas de foro.
- Autenticar usuarios mediante tokens JWT.

## Características
- **Gestión de Foros**: Administración de temas con operaciones como crear, leer, actualizar y eliminar.
- **Autenticación de Usuarios**: Autenticación segura con Spring Security y JWT.
- **Paginación**: Listado de temas con soporte de paginación.
- **Validación**: Validación de entradas en las solicitudes para garantizar la integridad de los datos.

## Tecnologías Utilizadas
- **Java**
- **Spring Boot** (Web, Security, Data JPA)
- **Auth0** para la autenticación de usuarios
- **Base de datos MySQL** (desarrollo) o cualquier base de datos compatible (producción)
- **Flyway** para migraciones de base de datos
- **Maven** para la gestión de dependencias

## Endpoints
### Gestión de Temas
URL base: `/api/topicos`

| Método HTTP | Endpoint            | Descripción                   |
|--------------|---------------------|----------------------------------|
| GET          | `/api/topicos`      | Obtener todos los temas con paginación. |
| GET          | `/api/topicos/{id}` | Obtener un tema específico por ID. |
| POST         | `/api/topicos`      | Crear un nuevo tema.             |
| PUT          | `/api/topicos`      | Actualizar un tema existente.    |
| DELETE       | `/api/topicos/{id}` | Eliminar un tema por ID.         |

#### Ejemplo de Cargas Útiles
**Crear Tema (`POST /api/topicos`)**:
```json
{
  "titulo": "Conceptos Básicos de Spring Boot",
  "mensaje": "Este post trata sobre los conceptos básicos de Spring Boot.",
  "user_id": 1,
  "curso": "Java"
}
```

**Actualizar Tema (`PUT /api/topicos`)**:
```json
{
  "id": 1,
  "titulo": "Título Actualizado",
  "mensaje": "Contenido del mensaje actualizado.",
  "curso": "Java Avanzado"
}
```

### Autenticación
URL base: `/login`

| Método HTTP | Endpoint | Descripción                         |
|--------------|----------|-------------------------------------|
| POST         | `/login` | Autenticar usuario y obtener token JWT. |

#### Ejemplo de Carga útil
**Inicio de Sesión (`POST /login`)**:
```json
{
  "email": "usuario@ejemplo.com",
  "password": "contraseña123"
}
```

#### Ejemplo de Respuesta
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

## Modelos de Datos
### Tema
- **TopicoCreateDTO**: Para crear nuevos temas.
- **TopicoResponseDTO**: Para devolver detalles de temas.
- **TopicoUpdateDTO**: Para actualizar temas existentes.

### Autenticación
- **AuthenticationUserDTO**: Para solicitudes de inicio de sesión de usuarios.
- **DatosJWTToken**: Para devolver tokens JWT.

## Validación
Todos los DTO incluyen validación de entradas para garantizar:
- Que los campos requeridos estén presentes.
- Que los formatos de datos sean correctos.

## Ejecución de la Aplicación
### Requisitos Previos
- Java 17 o superior
- Maven

### Pasos
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/SoyElGary1/ForoHubApi.git
   ```
2. Navegar al directorio del proyecto:
   ```bash
   cd foro
   ```

### Pruebas
- Utilizar herramientas como Postman o cURL para probar los endpoints.

## Manejo de Errores
La API proporciona respuestas de error significativas:
- **404 No Encontrado**: Cuando no se encuentra un recurso solicitado.
- **400 Solicitud Incorrecta**: Para errores de validación.

## Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.

---

# ForoHub API - Forum Application

## Overview
ForoHub API is a RESTful web service designed for managing forum topics ("topicos") and providing user authentication using Spring Security and Auth0. The application allows users to:

- Create, read, update, and delete (CRUD) forum topics.
- Authenticate users via JWT tokens.

## Features
- **Forum Management**: Manage topics with operations such as create, read, update, and delete.
- **User Authentication**: Secure authentication with Spring Security and JWT.
- **Pagination**: List topics with pagination support.
- **Validation**: Input validation for requests to ensure data integrity.

## Technologies Used
- **Java**
- **Spring Boot** (Web, Security, Data JPA)
- **Auth0** for user authentication
- **MySQL Database** (development) or any compatible database (production)
- **Flyway** for database migrations
- **Maven** for dependency management

## Endpoints
### Topic Management
Base URL: `/api/topicos`

| HTTP Method | Endpoint            | Description                |
|-------------|---------------------|----------------------------|
| GET         | `/api/topicos`      | Get all topics with pagination. |
| GET         | `/api/topicos/{id}` | Get a specific topic by ID. |
| POST        | `/api/topicos`      | Create a new topic.        |
| PUT         | `/api/topicos`      | Update an existing topic.  |
| DELETE      | `/api/topicos/{id}` | Delete a topic by ID.      |

#### Example Payloads
**Create Topic (`POST /api/topicos`)**:
```json
{
  "titulo": "Spring Boot Basics",
  "mensaje": "This post is about Spring Boot basics.",
  "user_id": 1,
  "curso": "Java"
}
```

**Update Topic (`PUT /api/topicos`)**:
```json
{
  "id": 1,
  "titulo": "Updated Title",
  "mensaje": "Updated message content.",
  "curso": "Advanced Java"
}
```

### Authentication
Base URL: `/login`

| HTTP Method | Endpoint | Description                   |
|-------------|----------|-------------------------------|
| POST        | `/login` | Authenticate user and get JWT token. |

#### Example Payload
**Login (`POST /login`)**:
```json
{
  "email": "user@example.com",
  "password": "password123"
}
```

#### Example Response
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

## Data Models
### Topic
- **TopicoCreateDTO**: For creating new topics.
- **TopicoResponseDTO**: For returning topic details.
- **TopicoUpdateDTO**: For updating existing topics.

### Authentication
- **AuthenticationUserDTO**: For user login requests.
- **DatosJWTToken**: For returning JWT tokens.

## Validation
All DTOs include input validation to ensure:
- Required fields are present.
- Data formats are correct.

## Running the Application
### Prerequisites
- Java 17 or higher
- Maven

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/SoyElGary1/ForoHubApi.git
   ```
2. Navigate to the project directory:
   ```bash
   cd foro
   ```

### Testing
- Use tools like Postman or cURL to test endpoints.
## Error Handling
The API provides meaningful error responses:
- **404 Not Found**: When a requested resource is not found.
- **400 Bad Request**: For validation errors.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

