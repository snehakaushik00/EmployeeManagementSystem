Employee Leave Management System

A backend application developed using Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL to simplify employee management and automate the leave application and approval process.

📌 About the Project

The Employee Leave Management System is a REST API-based backend application designed to manage employee records and leave requests efficiently.

Employees can register, log in, and apply for leaves by providing the start date, end date, and reason. Administrators can manage employee records, view leave applications, and approve leave requests.

The project follows a layered architecture to maintain clean code, separation of concerns, and better maintainability.

🛠️ Technologies Used
Programming Language: Java

Framework: Spring Boot

ORM Framework: Hibernate

Persistence Framework: Spring Data JPA

Database: MySQL

API Development: REST APIs

Build Tool: Maven

IDE: IntelliJ IDEA

✨ Features
Employee Registration and Login: Allows employees to register and log in.

Employee Management: Perform CRUD operations on employee records.

Apply for Leave: Employees can submit leave requests.

View Leave Requests: Retrieve and view submitted leave applications.

Leave Approval: Administrators can approve leave requests.

DTO Implementation: Uses Data Transfer Objects to transfer data between application layers.

Input Validation: Ensures valid input data.

Exception Handling: Implements custom and global exception handling.

Pagination and Sorting: Efficiently retrieves and organizes records.

Basic Authentication: Provides basic application authentication.

🏗️ Project Architecture

The application follows a layered architecture:

Layer	Responsibility

Controller Layer	Handles incoming HTTP requests and REST API endpoints.

Service Layer	Contains business logic and application operations.

Repository Layer	Handles database interactions using Spring Data JPA.

Entity Layer	Defines database entities and relationships.

DTO Layer	Transfers data between different application layers.

🗄️ Database

MySQL is used to store employee information, user details, and leave request records.

Hibernate and Spring Data JPA are used for ORM and database operations.

🎯 Project Objective

This project demonstrates practical knowledge of Java backend development, Spring Boot, REST API development, database integration, application security, and exception handling.

It also provides hands-on experience with building a real-world backend application using a layered architecture.
