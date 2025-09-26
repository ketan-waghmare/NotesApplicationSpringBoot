### 📓 Notes Application Spring Boot
Overview

The Notes Application is a simple Spring Boot-based RESTful web service that allows users to perform CRUD (Create, Read, Update, Delete) operations on notes. It serves as a foundational project to demonstrate the capabilities of Spring Boot in building microservices.

### Features

CRUD Operations: Create, Read, Update, and Delete notes.

RESTful API: Exposes endpoints to interact with notes.

Persistence Layer: Utilizes an in-memory H2 database for data storage.

### Technologies Used

Spring Boot 3.5.5: The core framework for building the application.

Spring Web: For building RESTful web services.

Spring Data JPA: To interact with the database.

H2 Database: An in-memory database for development and testing.

Setup and Installation
Prerequisites

Java 17 or higher

Maven for dependency management and build

Clone the Repository
git clone https://github.com/ketan-waghmare/NotesApplicationSpringBoot.git
cd NotesApplicationSpringBoot

Build the Project
./mvnw clean install

Run the Application
./mvnw spring-boot:run


The application will start on port 8080 by default.

