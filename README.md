# Library Management System - Complete Documentation

## Project Overview

The **Library Management System** is a console-based Java application designed to manage library operations including book inventory, member management, and staff administration. This system provides a menu-driven interface for librarians and administrators to efficiently manage library resources.

---

## Table of Contents

1. [Project Architecture](#project-architecture)
2. [System Features](#system-features)
3. [File Structure](#file-structure)
4. [Core Components](#core-components)
5. [Technical Stack](#technical-stack)
6. [How to Run](#how-to-run)
7. [Usage Guide](#usage-guide)
8. [Code Explanation](#code-explanation)

---

## Project Architecture

This system follows an **Object-Oriented Programming (OOP)** design pattern with the following principles:

- **Encapsulation**: Each class manages its own data and behavior
- **Inheritance**: `ReferenceBook` inherits from `Book` base class
- **Modularity**: Separate packages for different functionalities
- **Data Management**: Uses `ArrayList` collections for dynamic storage

### Architecture Diagram

```
Entry.java (Main Entry Point)
    ↓
Menu System
    ├── Book Management (Book.java, ReferenceBook.java)
    ├── Member Management (Member.java)
    ├── Librarian Management (Librarian.java)
    └── Display & Search Operations
```

---

## System Features

### 1. **Book Management**
- Add regular books to the library inventory
- Add reference books (non-borrowable)
- Display book information
- Search for specific books

### 2. **Reference Book Management**
- Maintain reference collection (encyclopedias, dictionaries, etc.)
- Track reference book availability
- Display reference book details

### 3. **Member Management**
- Register new library members
- Track member information
- Display all members
- Manage member borrowing history

### 4. **Librarian Management**
- Register librarian staff
- Track librarian information
- Display all librarians
- Manage staff assignments

---

## File Structure

```
library system/
├── src/
│   ├── Entry.java                 # Main entry point with menu system
│   ├── Main.java                  # Template file (not used)
│   ├── Library/
│   │   ├── Member.java            # Member class definition
│   │   ├── Book/
│   │   │   ├── Book.java          # Base book class
│   │   │   └── ReferenceBook.java # Reference book class (extends Book)
│   │   └── member/                # Package folder
│   └── stuff/
│       └── Librarian/
│           └── Librarian.java     # Librarian class definition
├── bin/                           # Compiled .class files (auto-generated)
├── .gitignore                     # Git ignore rules
└── README.md                      # This file
```

---

## Core Components

### 1. **Entry.java** - Main Application Controller

**Purpose**: Acts as the central hub for the entire application, managing the menu system and user interactions.

**Key Features**:
- Menu-driven interface
- Scanner for user input
- Collections for data storage
- Exception handling for input validation

**Main Collections**:
```java
private static final ArrayList<Book> books;           // Regular books
private static final ArrayList<ReferenceBook> refBooks;  // Reference books
private static final ArrayList<Member> members;       // Library members
private static final ArrayList<Librarian> librarians; // Staff members
```

**Menu Options**:
1. Add Book
2. Add Reference Book
3. Add Member
4. Add Librarian
5. Display Book Information
6. Display Reference Book Information
7. Display All Members
8. Display All Librarians
9. Exit

---

### 2. **Book.java** - Book Entity

**Purpose**: Represents a borrowable book in the library system.

**Key Attributes**:
- `ISBN`: Unique book identifier
- `title`: Book title
- `author`: Author name
- `year`: Publication year
- `quantity`: Number of copies available
- `isBorrowed`: Borrowing status

**Key Methods**:
- Constructor with book details
- Getter and setter methods
- toString() for display

**Example Usage**:
```java
Book book = new Book("ISBN123", "Java Basics", "John Doe", 2023, 5, false);
```

---

### 3. **ReferenceBook.java** - Reference Book Entity

**Purpose**: Represents a non-borrowable reference book (extends Book).

**Key Differences from Book**:
- Cannot be borrowed by members
- Always available in library
- Used for on-site reference only

**Inheritance**:
```java
public class ReferenceBook extends Book {
    // Additional reference-specific properties
}
```

**Example Usage**:
```java
ReferenceBook refBook = new ReferenceBook("ISBN456", "Encyclopedia", "Editor", 2023, 2, false);
```

---

### 4. **Member.java** - Member Entity

**Purpose**: Represents a library member who can borrow books.

**Key Attributes**:
- `memberID`: Unique member identifier
- `name`: Member name
- `email`: Contact email
- `phone`: Contact phone number
- `joinDate`: Date of membership
- `borrowedBooks`: List of borrowed books

**Key Methods**:
- Register new member
- Track borrowed books
- Update member information
- Display member details

**Example Usage**:
```java
Member member = new Member("M001", "Alice Smith", "alice@email.com", "123-456-7890");
```

---

### 5. **Librarian.java** - Librarian Entity

**Purpose**: Represents library staff managing operations.

**Key Attributes**:
- `librarianID`: Unique staff identifier
- `name`: Librarian name
- `department`: Department assignment
- `phone`: Contact number
- `joinDate`: Employment date

**Key Methods**:
- Register librarian
- Manage assigned responsibilities
- Display librarian information

**Example Usage**:
```java
Librarian librarian = new Librarian("L001", "Bob Johnson", "Circulation", "987-654-3210");
```

---

## Technical Stack

### **Programming Language**
- **Java SE 25 LTS** (Long-Term Support)

### **Core Technologies Used**

| Technology | Purpose |
|-----------|---------|
| **ArrayList** | Dynamic data collection storage |
| **Scanner** | User input handling |
| **Exception Handling** | Error management (InputMismatchException) |
| **OOP Principles** | Class design and inheritance |
| **String Formatting** | User-friendly output display |

### **Development Tools**
- **IDE**: IntelliJ IDEA or VS Code
- **Compiler**: Java Compiler (javac)
- **Runtime**: Java Virtual Machine (JVM)
- **Version Control**: Git (optional)

---

## How to Run

### **Step 1: Navigate to Project Directory**
```cmd
cd "c:\Users\lenovo\Desktop\Myproject\library system"
```

### **Step 2: Compile All Source Files**
```cmd
javac -d bin src\Entry.java src\Main.java src\Library\Member.java src\Library\Book\Book.java src\Library\Book\ReferenceBook.java src\stuff\Librarian\Librarian.java
```

**What this does**:
- `-d bin`: Places compiled `.class` files in `bin` directory
- Compiles all 6 Java source files
- Resolves package dependencies

### **Step 3: Run the Application**
```cmd
java -cp bin Entry
```

**What this does**:
- `-cp bin`: Sets classpath to look for classes in `bin` directory
- `Entry`: Runs the main class (Entry.java)

### **Expected Output**:
```
========= LIBRARY MANAGEMENT SYSTEM =========
1)  Add Book
2)  Add Reference Book
3)  Add Member
4)  Add Librarian
5)  Display Book Information
6)  Display Reference Book Information
7)  Display All Members
8)  Display All Librarians
9)  Exit
=============================================
Enter your choice:
```

---

## Usage Guide

### **Adding a Book (Option 1)**

```
Enter your choice: 1
Enter ISBN: 9780134685991
Enter Title: Effective Java
Enter Author: Joshua Bloch
Enter Year: 2017
Enter Quantity: 3
```

**What happens**: Book is added to the `books` ArrayList and can be borrowed by members.

### **Adding a Reference Book (Option 2)**

```
Enter your choice: 2
Enter ISBN: 9780134685992
Enter Title: Java Reference Manual
Enter Author: Oracle Corporation
Enter Year: 2023
Enter Quantity: 1
```

**What happens**: Reference book is added to `refBooks` ArrayList but cannot be borrowed.

### **Adding a Member (Option 3)**

```
Enter your choice: 3
Enter Member ID: M001
Enter Name: John Smith
Enter Email: john@example.com
Enter Phone: 555-1234
```

**What happens**: Member is registered and can borrow books.

### **Adding a Librarian (Option 4)**

```
Enter your choice: 4
Enter Librarian ID: L001
Enter Name: Sarah Johnson
Enter Department: Circulation
Enter Phone: 555-5678
```

**What happens**: Librarian staff member is registered.

### **Display Options (5-8)**

- **Option 5**: Shows all books in the system with details
- **Option 6**: Shows all reference books with details
- **Option 7**: Lists all registered members
- **Option 8**: Lists all librarian staff

### **Exit (Option 9)**

```
Enter your choice: 9
Exiting program. Goodbye!
```

---

## Code Explanation

### **Main Loop in Entry.java**

```java
public static void main(String[] args) {
    boolean exit = false;
    while (!exit) {
        displayMenu();
        try {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1 -> addBook();
                case 2 -> addReferenceBook();
                case 3 -> addMember();
                case 4 -> addLibrarian();
                case 5 -> displayBooksMenu();
                case 6 -> displayRefBooksMenu();
                case 7 -> displayAllMembers();
                case 8 -> displayAllLibrarians();
                case 9 -> {
                    System.out.println("Exiting program. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Please choose 1-9.");
            }
        } catch (InputMismatchException ime) {
            System.out.println("Input error: please enter numbers where required.");
            scanner.nextLine(); // clear bad input
        }
    }
}
```

**How it works**:
1. **Loop**: Continuous menu display until user exits
2. **Scanner**: Reads integer input from user
3. **Switch Statement**: Routes to appropriate method based on choice
4. **Exception Handling**: Catches non-integer inputs
5. **Exit Condition**: Set to true when user selects option 9

### **Error Handling Pattern**

```java
try {
    // User input operations
} catch (InputMismatchException ime) {
    // Handle wrong input type
    System.out.println("Input error: please enter numbers where required.");
    scanner.nextLine(); // Clear the invalid input
}
```

**Why this matters**:
- Prevents program crashes from invalid input
- Allows user to re-enter data
- Provides user-friendly error messages

### **Data Storage Pattern**

```java
private static final ArrayList<Book> books = new ArrayList<>();

// Adding data
public static void addBook() {
    // Get user input
    Book book = new Book(isbn, title, author, year, quantity, false);
    books.add(book);
}

// Displaying data
public static void displayBooks() {
    for (Book book : books) {
        System.out.println(book.toString());
    }
}
```

**Why ArrayList**:
- Dynamic size (grows as needed)
- Easy iteration with enhanced for-loop
- Built-in methods (add, remove, size, etc.)

---

## Key Concepts Explained

### **OOP - Object-Oriented Programming**

This system demonstrates core OOP concepts:

1. **Encapsulation**: Each class hides internal data
   ```java
   private String ISBN;  // Hidden from outside
   public String getISBN() { return ISBN; }  // Controlled access
   ```

2. **Inheritance**: ReferenceBook extends Book
   ```java
   public class ReferenceBook extends Book {
       // Inherits all Book properties
       // Can add reference-specific features
   }
   ```

3. **Polymorphism**: Different types stored in same collection
   ```java
   ArrayList<Book> books;  // Can store ReferenceBook too
   ```

### **Collections Framework**

```java
ArrayList<Book> books = new ArrayList<>();
// ArrayList is dynamic array implementation
// Automatically grows when needed
// Provides methods: add(), remove(), get(), size()
```

### **Input Validation**

The system validates user input to prevent crashes:
- Catches non-integer input with `InputMismatchException`
- Clears invalid input with `scanner.nextLine()`
- Re-displays menu for retry

---

## Performance Considerations

### **Current Implementation**
- **Time Complexity**: O(n) for search operations
- **Space Complexity**: O(n) where n = number of items

### **Possible Improvements**
- Use HashMap for O(1) lookups by ID
- Implement database persistence
- Add search optimization algorithms

---

## Future Enhancement Suggestions

1. **Database Integration**
   - Store data in MySQL/PostgreSQL
   - Persistent storage across sessions

2. **User Authentication**
   - Login system for members and staff
   - Role-based access control

3. **Advanced Features**
   - Due date tracking for borrowed books
   - Fine calculation system
   - Book reservation system

4. **GUI Implementation**
   - JavaFX or Swing interface
   - User-friendly visual design

5. **Search & Filter**
   - Search books by title, author, ISBN
   - Advanced filtering options

---

## Troubleshooting

### **Compilation Error: "file not found"**
- Ensure you're in the correct directory
- Check file paths are correct
- Use correct package structure in imports

### **Runtime Error: "NoSuchElementException"**
- Scanner is closed or no input available
- Ensure console window is active for input

### **ClassNotFoundException**
- Classpath (-cp) not set correctly
- Compiled files might be in wrong directory

### **InputMismatchException**
- User entered text instead of numbers
- Program will catch this and ask for retry

---

## Conclusion

The Library Management System is a comprehensive console application demonstrating:
- ✅ Object-Oriented Design Principles
- ✅ Collections Framework (ArrayList)
- ✅ Exception Handling
- ✅ User Input Management
- ✅ Menu-Driven Architecture

This foundation can be extended with databases, GUI, and advanced features for a complete library management solution.

---

## Contact & Support

For questions or improvements to this system, refer to the source code comments or consult Java documentation:
- [Java SE Documentation](https://docs.oracle.com/javase/)
- [Java Collections Framework](https://docs.oracle.com/javase/tutorial/collections/)

---

**Last Updated**: November 21, 2025  
**Java Version**: SE 25 LTS  
**Status**: Functional Console Application
