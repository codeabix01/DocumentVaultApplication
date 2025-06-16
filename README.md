
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
> "Generate a Spring Boot DocumentController class with endpoints for uploading and downloading files. Use Swagger annotations for API documentation. The upload endpoint should accept a MultipartFile and save it to a local directory named uploads. The download endpoint should retrieve a file by its name from the same directory and return it as a response. Include error handling for missing files and server errors. Ensure the upload directory is created using a @PostConstruct method."

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

### POSTMAN CURL FOR UPLOAD 

curl --location 'http://localhost:8080/documents/upload' \
--header 'Authorization: Bearer ' \
--header 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYW5hIiwiaWF0IjoxNzUwMDU2ODExLCJleHAiOjE3NTAxNDMyMTF9._aAzK-_gs2-hv0r_FBYe3J_q_H1M6H2dOzblyalDjpc;' \
--header 'Cookie: JSESSIONID=911090D99D0C84B43AF2BB58DA2A6C88' \
--form 'file=@"postman-cloud:///1f04860e-578e-40d0-b321-181ad37ed579"'

###MAKE SURE TO ADD GENERATED TOKEN WHILE REGISTERING.

## IMAGES TO REFER THE WORKING CODE

## SWAGGER VIEW

![SWAGGER_UI.png](SWAGGER_UI.png "SWAGGER_UI")


## REGISTER USER

![REGISTER_USER.png](REGISTER_USER.png "REGISTER ")


## LOGIN USER

![LOGIN_USER.png](LOGIN_USER.png "LOGIN")


## DOWNLOAD

![Downloaded_JWT.png](Downloaded_JWT.png "Download through JWT")

## UPLOAD

![UPLOAD_JWT.png](UPLOAD_JWT.png "UPLOAD through JWT")



