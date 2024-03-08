# Digimon API Service

Welcome to the Digimon API Service! This project provides a RESTful API service built using Java with Spring Boot for managing Digimons and Tamers in a PostgreSQL database.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This API service allows users to perform CRUD (Create, Read, Update, Delete) operations on Digimons and Tamers. It provides a simple and efficient way to manage data related to Digimons and Tamers, including their attributes, evolution, and related information.

## Features

- **Create:** Add new Digimons and Tamers to the database.
- **Read:** Retrieve information about Digimons and Tamers from the database.
- **Update:** Modify existing Digimons and Tamers in the database.
- **Delete:** Remove Digimons and Tamers from the database.

## Requirements

Before running this application, ensure you have the following prerequisites installed:

- Java Development Kit (JDK) 8 or later
- Apache Maven
- PostgreSQL database

## Getting Started

1. Clone this repository to your local machine:
   ```
   git clone https://github.com/your-username/digimon-api-service.git
   ```
2. Navigate to the project directory:
  ```
  cd digimon-api-service
  ```
3. Build the project using Maven:
  ```
  mvn clean install
  ```
4. Configure the PostgreSQL database connection in `application.properties`.
5. Run the application:
  ```
  java -jar target/digimon-api-service.jar
  ```
6. Access the API endpoints using a tool like Postman or your preferred web browser.

   
## API Endpoints

### Digimon Endpoints

- `GET /api/digimons`: Retrieve all Digimons.
- `GET /api/digimons/{id}`: Retrieve a Digimon by ID.
- `POST /api/digimons`: Create a new Digimon.
- `PUT /api/digimons/{id}`: Update an existing Digimon.
- `DELETE /api/digimons/{id}`: Delete a Digimon by ID.

### Tamer Endpoints

- `GET /api/tamers`: Retrieve all Tamers.
- `GET /api/tamers/{id}`: Retrieve a Tamer by ID.
- `POST /api/tamers`: Create a new Tamer.
- `PUT /api/tamers/{id}`: Update an existing Tamer.
- `DELETE /api/tamers/{id}`: Delete a Tamer by ID.

## Contributing

Contributions are welcome! Feel free to fork this repository, make changes, and submit pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
