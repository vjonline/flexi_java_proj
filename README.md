# Java Database Inventory Management System

A college project demonstrating Java database integration using JDBC, DAO pattern, and object-oriented programming principles.

## Project Overview

This is a command-line inventory management system that allows users to manage customers, products, orders, and suppliers through a MySQL database. The application showcases key Java concepts including polymorphism, exception handling, and database connectivity.

## Features

- **Customer Management**: Add and manage customer information
- **Product Management**: View products with pricing and stock levels
- **Order Processing**: Place orders and calculate totals dynamically
- **Stock Checking**: Real-time stock verification using database functions
- **Polymorphic Design**: Implements interface-based polymorphism for flexible data access

## Technologies Used

- **Java**: Core programming language
- **JDBC**: Database connectivity
- **MySQL**: Database management system
- **DAO Pattern**: Data Access Object for clean separation of concerns
- **Object-Oriented Programming**: Encapsulation, inheritance, polymorphism

## Prerequisites

- Java JDK (version 8 or higher)
- MySQL Server
- MySQL Connector/J (JDBC driver)
- VS Code with Java extensions

## Setup Instructions

1. **Clone/Download the Project**
   ```
   cd your-workspace-directory
   # Copy project files to flexi_java_proj folder
   ```

2. **Database Setup**
   - Install MySQL Server
   - Create a database named `inventory_db`
   - Run the provided SQL scripts to create tables, functions, and procedures
   - Update `src/db.properties` with your database credentials:
     ```
     db.url=jdbc:mysql://localhost:3306/inventory_db
     db.username=your_username
     db.password=your_password
     ```

3. **Dependencies**
   - Place MySQL Connector/J JAR file in the `lib` folder
   - The project uses JDBC for database operations

4. **Compile and Run**
   ```
   # Compile
   javac -cp "lib/*" -d bin src/**/*.java

   # Run
   java -cp "bin:lib/*" ui.MainCLI
   ```

## Project Structure

```
flexi_java_proj/
├── src/
│   ├── dao/          # Data Access Objects (CustomerDAO, ProductDAO, etc.)
│   ├── db/           # Database connection utilities
│   ├── model/        # Entity classes (Customer, Product, Order, etc.)
│   ├── service/      # Business logic layer
│   ├── ui/           # User interface (MainCLI)
│   └── util/         # Utility classes
├── lib/              # External dependencies (JDBC driver)
├── bin/              # Compiled class files
└── README.md         # This file
```

## Usage

Run the application and use the menu options:

1. Add Customer
2. View Products
3. Place Order
4. View Orders
5. Check Stock
6. Exit

## Key Concepts Demonstrated

- **DAO Pattern**: Clean separation between business logic and data access
- **Polymorphism**: Interface implementation for flexible method calls
- **JDBC Operations**: PreparedStatements, ResultSets, and connection management
- **Exception Handling**: Proper error handling for database operations
- **Encapsulation**: Private fields with getters/setters in model classes

## Database Schema

The system uses the following main tables:
- `Customer`: Customer information
- `Product`: Product catalog with pricing
- `Orders`: Order records
- `OrderProduct`: Order-product relationships
- `Supplier`: Supplier information

## Contributing

This is a college project for educational purposes. Feel free to modify and extend the functionality.

## License

Academic project - no specific license applied.
