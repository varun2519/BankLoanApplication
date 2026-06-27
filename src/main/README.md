# Bank Loan Application

## Overview

The Bank Loan Application is a backend REST API developed using Java and Spring Boot. It enables users to manage bank loan applications by providing APIs to create, retrieve, update, and delete loan records. The application follows a layered architecture and integrates with a MySQL database using Spring Data JPA and Hibernate.

## Features

* Create a new loan application
* Retrieve all loan applications
* Retrieve a loan application by ID
* Update loan application details
* Delete loan applications
* Input validation using Spring Validation
* MySQL database integration
* Exception handling

## Tech Stack

* Java 17
* Spring Boot
* Spring Web MVC
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Eclipse IDE
* Git & GitHub
* Postman

## Project Structure

```text
src
├── controller
├── service
├── repository
├── model
├── exception
└── BankLoanApplication.java
```

## Getting Started

### Prerequisites

* Java 17
* Maven
* MySQL
* Eclipse IDE (or any Java IDE)

### Installation

1. Clone the repository:

```bash
git clone https://github.com/varun2519/BankLoanApplication.git
```

2. Configure the MySQL database in `application.properties`.

3. Run the Spring Boot application.

4. Test the REST APIs using Postman.

## Future Enhancements

* Spring Security
* JWT Authentication
* Swagger/OpenAPI Documentation
* Loan Approval Workflow
* Email Notifications
* Unit Testing

## Author

**Varun Kumar**
