# 🏦 Bank Account Management System
A console-based Bank Account Management System developed using Core Java.
This project allows users to create bank accounts, deposit money, withdraw funds, and check account balances, while demonstrating strong Object-Oriented Programming (OOP) principles and persistent data storage using File Handling / JDBC.

# 📌 Project Overview
The Bank Account Management System is a menu-driven Java console application designed to simulate basic banking operations.
Each account stores essential details such as Account Number, Account Holder Name, and Balance.
The application ensures data persistence using file handling, so account details remain saved even after the program is closed.
This project highlights practical implementation of OOP concepts, data persistence, and clean modular design in Java.

# ✨ Features
•Create new bank accounts
•Deposit money into an account
•Withdraw money from an account
•Check account balance
•Persistent storage using file handling
•Menu-driven console interface
•Input validation and error handling
•Clean and structured console output

# 🧠 OOP Concepts Used
1) Encapsulation
Account data is kept private and accessed through methods
2)Inheritance
SavingsAccount class extends the base Account class
3)Abstraction
Common account behavior defined using an abstract class
4)Polymorphism
Deposit and withdrawal methods are overridden
5)Modular Design
Code is organized into logical methods and classes

# 🛠 Technologies Used
•Programming Language: Java (Core Java)
•Concepts: Object-Oriented Programming (OOP)
•Data Storage: File Handling (Serializable)
•Optional Database: JDBC (MySQL – Extendable)
•IDE: VS Code / IntelliJ IDEA
•Version Control: Git & GitHub

# 🗂 Project Structure
Bank-Account-Management-System/
│
├── Task 2/
│   └── BankSystem.java
│
├── accounts.dat
├── README.md
└── .gitignore

# 📂 Data Storage
•Account details are stored in a file named accounts.dat
•Uses Java serialization to save and retrieve data
•Ensures data persistence across multiple executions

# ⚠️ Challenges Faced
•Implementing OOP principles correctly
•Handling invalid user input
•Maintaining persistent data using file handling
•Preventing duplicate account creation

# 🏁 Conclusion
This project serves as a practical example of how Core Java can be used to build a real-world console application.
It demonstrates effective use of OOP principles, file handling, and clean coding practices, making it ideal for academic projects, interviews, and portfolio showcasing.
