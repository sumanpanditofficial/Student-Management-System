#  Student Management System

A **console-based Student Management System** built in **Core Java**, demonstrating mastery of **OOP principles, multithreading, file I/O**, and clean modular design.  

This project simulates a real-world production system with **CRUD operations, auto-save functionality**, and a **layered architecture**.

---

##  Features

-  **CRUD Operations** → Create, Read, Update, Delete student records efficiently.  
-  **File Persistence** → Automatically saves student data to files to ensure reliability.  
-  **Multithreaded Auto-Save** → Data backed up every 6 seconds to minimize data loss.  
-  **Layered Architecture** → Organized into `model`, `service`, `util`, and `exception` packages for modularity.  
-  **OOP Principles** → Demonstrates encapsulation, inheritance, polymorphism, and abstraction.  
-  **Custom Exceptions** → Graceful handling of runtime errors in the system.  

---

##  Tech Stack

- **Language:** Java 17+  
- **Core Concepts:** OOP, Multithreading, File I/O, Exception Handling  
- **Architecture:** Layered (Model → Service → Util → Exception)  

---

##  How to Run

### 1. Clone the Repository
```bash
git clone https://github.com/sumanpanditofficial/Student-Management-System.git
cd Student-Management-System

//compile the project
javac -d bin src/**/*.java

//Run the project
java -cp bin com.suman.main.Main

