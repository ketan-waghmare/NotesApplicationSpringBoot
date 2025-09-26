📓 Notes Application Spring Boot
Overview

The Notes Application is a simple Spring Boot-based RESTful web service that allows users to perform CRUD (Create, Read, Update, Delete) operations on notes. It serves as a foundational project to demonstrate the capabilities of Spring Boot in building microservices.

Features

CRUD Operations: Create, Read, Update, and Delete notes.

RESTful API: Exposes endpoints to interact with notes.

Persistence Layer: Utilizes an in-memory H2 database for data storage.

Technologies Used

Spring Boot 3.5.5: The core framework for building the application.

Spring Web: For building RESTful web services.

Spring Data JPA: To interact with the database.

H2 Database: An in-memory database for development and testing.

Project Structure
NotesApplicationSpringBoot/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── notes/
│   │   │           ├── controller/
│   │   │           │   └── NoteController.java
│   │   │           ├── model/
│   │   │           │   └── Note.java
│   │   │           ├── repository/
│   │   │           │   └── NoteRepository.java
│   │   │           └── service/
│   │   │               └── NoteService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
└── pom.xml

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

API Endpoints
Create a Note

URL: /api/notes

Method: POST

Request Body:

{
  "title": "Sample Note",
  "content": "This is a sample note."
}


Response:

{
  "id": 1,
  "title": "Sample Note",
  "content": "This is a sample note."
}

Get All Notes

URL: /api/notes

Method: GET

Response:

[
  {
    "id": 1,
    "title": "Sample Note",
    "content": "This is a sample note."
  }
]

Get a Note by ID

URL: /api/notes/{id}

Method: GET

Response:

{
  "id": 1,
  "title": "Sample Note",
  "content": "This is a sample note."
}

Update a Note

URL: /api/notes/{id}

Method: PUT

Request Body:

{
  "title": "Updated Note",
  "content": "This is an updated note."
}


Response:

{
  "id": 1,
  "title": "Updated Note",
  "content": "This is an updated note."
}

Delete a Note

URL: /api/notes/{id}

Method: DELETE

Response: 204 No Content

Database Configuration

The application uses an in-memory H2 database. The schema and initial data are populated using the data.sql file located in src/main/resources/.
