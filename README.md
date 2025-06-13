
# Document Vault — Hackathon Project

## Overview
This project is a secure document storage and retrieval service with user authentication and role-based authorization. Built with Java 17 and Spring Boot 3.x, it features JWT-based security, upload/download endpoints, and in-memory H2 database. Built from scratch without Spring Initializr for maximum learning and customizability.

---

## 🛠️ Steps Taken to Build the Project

### Prompt-Driven Instructions and Steps

#### Prompt 1:
> "I want a Spring Boot application built from scratch — not using Spring Initializr — with login, register, JWT auth, document upload/download, and H2 database."

✅ Created Gradle-based project manually in IntelliJ  
✅ Added necessary Spring Boot plugins and dependencies manually in build.gradle

#### Prompt 2:
> "Add authentication and JWT-based login and registration functionality."

✅ User entity with username, password, role  
✅ JWT token generation and validation  
✅ AuthController for /register and /login endpoints  
✅ Spring Security configured for JWT

#### Prompt 3:
> "Use in-memory H2 database."

✅ H2 dependency and configured application.properties  
✅ H2 console enabled

#### Prompt 4:
> "Add endpoints for uploading and downloading documents."

✅ DocumentController with /upload and /download/{filename} endpoints  
✅ Upload returns filename; download returns file as Resource

#### Prompt 5:
> "Add a full README"

✅ README.md with tech stack, features, sample payloads, and run instructions  

#### Prompt 6:
> "Add Swagger provide dependency and bean fix and unit/integration tests."

✅ Integrated springdoc-openapi-ui for Swagger  
 ->  Run swagger UI at http://localhost:8080/swagger-ui/index.html

✅ All endpoints accessible at /swagger-ui.html  
✅ Added JUnit5 and Mockito  
✅ Tests for JwtService, UserService, and AuthController

---

## 📦 Directory Structure

```
DocumentVault/
├── build.gradle
├── README.md
├── src
│   ├── main
│   │   ├── java/org/example
│   │   │   ├── config
│   │   │   ├── controller
│   │   │   ├── dto
│   │   │   ├── entity
│   │   │   ├── repository
│   │   │   ├── service
│   │   │   └── DocumentVaultApplication.java
│   │   └── resources/application.properties
│   └── test/java/org/example
│       ├── service
│       └── controller
```
