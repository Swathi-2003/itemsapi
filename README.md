# Items REST API – Java Spring Boot

This project is a simple Java backend application built using Spring Boot.  
It implements a RESTful API for managing a collection of items (example: movies or products).

The application uses **in-memory storage** (ArrayList) and does not require any database.

##  Features
- RESTful API using Spring Boot
- In-memory data storage using `ArrayList`
- Add a new item
- Fetch a single item by ID
- Input validation for required fields
- No database dependency
- Lightweight and easy to run

---

## Technologies Used
- Java 17
- Spring Boot
- Maven
- REST API
- Embedded Tomcat Server

---

## Project Structure

- `model` – Contains the Item model class  
- `controller` – Contains REST API endpoints  
- `ItemsapiApplication.java` – Main Spring Boot application class  
itemsapi
├── src/main/java/com/demo/itemsapi
│ ├── ItemsapiApplication.java
│ ├── controller
│ │ └── ItemController.java
│ └── model
│ └── Item.java
├── pom.xml
├── mvnw / mvnw.cmd
└── README.md
---

## Item Model

Each item has the following fields:
- `id` (int)
- `name` (String)
- `description` (String)

---

## API Endpoints

### 1. Add a New Item
- **URL:** `/items`
- **Method:** POST
- **Request Body (JSON):**
```json
{
  "id": 1,
  "name": "Movie",
  "description": "Action movie"
}
Validation:
Name must not be empty
Description must not be empty

Response:
Item added successfully

### 2. Get Item by ID

URL: /items/{id}
Method: GET

Example:

GET /items/1


Response (JSON):

{
  "id": 1,
  "name": "Movie",
  "description": "Action movie"
}

Data Storage:
Items are stored in memory using ArrayList
No database is used
Data resets when the application restarts

How to Run the Application Locally
Open the project folder
  cd itemsapi

  Run the following command:

                 ./mvnw spring-boot:run


The application will start on:

http://localhost:8080

Hosting:
The application can be deployed on platforms like Render to generate a public URL for demo purposes.

Notes
This project is created as a sample task to demonstrate Java backend and REST API development.
Only required features are implemented as per the task instructions.

Author
  Swathi S