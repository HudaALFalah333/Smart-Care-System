# Smart Care System

Smart Care is a Java-based hospital management system developed as part of my Advanced Programming coursework at Al Hussein Technical University (HTU).

The system is designed to manage hospital operations including patients, doctors, nurses, rooms, admissions, medical procedures, and reports.

## Features

### Admin
- Add doctors and nurses
- Manage hospital sections
- Manage rooms
- Generate reports

### Doctor
- Admit patients
- Discharge patients
- Add medical procedures
- Manage patient admissions

### Nurse
- Register patients
- View patient history
- Follow medical procedures
- Mark procedures as completed

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- JUnit
- UML

## System Design

The system was designed using UML before implementation.

The design includes classes for:

- Person
- Doctor
- Patient
- Nurse
- Admin
- Section
- Room
- Admission
- Medical Procedure
- Reports

### UML Class Diagram

The UML class diagram is included in the project documentation.

## OOP & Design Principles

The project applies several object-oriented design concepts:

- Abstraction
- Inheritance
- Interfaces
- Association
- Aggregation
- Composition
- Dependency

The implementation also follows Clean Code practices and SOLID principles:

- Single Responsibility Principle
- Open/Closed Principle
- Liskov Substitution Principle
- Interface Segregation Principle
- Dependency Inversion Principle

## System Architecture

The application separates responsibilities between:

**Domain Classes → Service Interfaces → Manager Classes → Action Classes → User Interaction**

This structure helps keep the application organized and maintainable.

## Testing

Automated testing was implemented using JUnit.

Three main areas were tested:

### Unit Testing
Room bed management:
- Check available beds
- Assign beds
- Release beds

### Integration Testing
Person management:
- Add doctors
- Search doctors
- Add patients

### System Testing
Complete system operations:
- Admin management operations
- Doctor admission and medical procedure operations
- Nurse patient and procedure operations

All implemented test cases passed successfully with no reported errors or failures.

## Documentation

The project documentation includes:

- System design
- UML class diagram
- Class relationships
- Clean Code practices
- SOLID principles
- Java implementation
- Test plan
- JUnit automated testing results

## Author

**Huda Al-Falah**  
Al Hussein Technical University (HTU)
