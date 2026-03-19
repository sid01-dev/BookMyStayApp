# Book My Stay App

## Project Overview

Book My Stay App is a simple Hotel Booking Management System developed using Core Java. The purpose of this project is to understand how object-oriented programming and basic data structures can be applied in real-world applications.

The system is built step by step using different use cases. Each use case introduces a new concept such as abstraction, inheritance, centralized data handling, and separation of responsibilities.

---

## Objectives

* To apply Core Java concepts in a practical project
* To understand object-oriented design principles
* To implement centralized inventory using data structures
* To avoid inconsistent and scattered data handling
* To build a scalable and maintainable system

---

## Use Cases

### Use Case 1: Application Entry

* Program starts execution using main() method
* Displays a welcome message and application version

### Use Case 2: Room Types and Static Availability

* Created an abstract Room class
* Implemented SingleRoom, DoubleRoom, and SuiteRoom
* Used static variables to store room availability

### Use Case 3: Centralized Inventory Management

* Introduced a RoomInventory class
* Used HashMap to store room availability
* Ensured single source of truth for all room data

### Use Case 4: Room Search and Availability Check

* Implemented a search service
* Displayed only available rooms
* Ensured read-only access without modifying inventory

---

## Project Structure

```
BookMyStayApp/
 └── src/
     ├── Main.java
     ├── Room.java
     ├── SingleRoom.java
     ├── DoubleRoom.java
     ├── SuiteRoom.java
     ├── RoomInventory.java
     └── RoomSearchService.java
```

---

## Technologies Used

* Java
* IntelliJ IDEA
* Git and GitHub

---

## Key Concepts Used

* Abstraction
* Inheritance
* Polymorphism
* Encapsulation
* HashMap
* Separation of concerns
* Read-only operations

---

## How to Run the Project

1. Clone the repository

```
git clone https://github.com/your-username/Book-My-Stay-App.git
```

2. Open the project in IntelliJ IDEA

3. Run Main.java

---

## Sample Output

```
Welcome to Book My Stay App
Hotel Booking System v1.0

Available Rooms:

Single Room | Beds: 1 | Price: ₹1000
Available: 5

Double Room | Beds: 2 | Price: ₹2000
Available: 3

Suite Room | Beds: 3 | Price: ₹5000
Available: 2
```

---

## Limitations

* No database integration
* No graphical user interface
* Booking functionality is not implemented yet

---

## Future Improvements

* Add booking system
* Prevent double booking
* Connect with database
* Develop a user interface

---

## Author

Sid G

---

## Note

This project is created for academic learning to understand how Java concepts are used in real applications.
