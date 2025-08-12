# Clean Code in Java 🧹

An educational Maven project demonstrating common code smells and their refactoring solutions in Java with practical, real-world examples.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Prerequisites](#prerequisites) 
- [Project Structure](#project-structure)
- [Quick Start](#quick-start)
- [Available Code Smells](#available-code-smells)
- [Running Instructions](#running-instructions)
- [Testing](#testing)
- [Contributing](#contributing)

## 🎯 Project Overview

This project serves as an educational resource for learning clean code principles through hands-on examples. Each code smell is demonstrated with:

- ✅ Before and after code comparisons
- ✅ Interactive console demonstrations
- ✅ Unit tests showing improvements

## 📋 Available Code Smells

### Bloaters
- **Long Method**: Extract Method refactoring to break down complex methods
- **Long Parameter List**: Introduce Parameter Object refactoring to group related parameters

### Object-Oriented Abusers
- **Switch Statements**: Replace Conditional with Polymorphism to eliminate switch statements

## 🔧 Prerequisites

- **Java 21** (OpenJDK 21.0.7+)
- **Maven 3.9+**
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)

### Installing Java 21

```bash
# Using SDKMAN (recommended)
sdk install java 21.0.7-tem

# For this project only (recommended approach)
# The project includes .sdkmanrc file for automatic environment switching
sdk env

# Or manually switch for this session only
sdk use java 21.0.7-tem

# Verify installation
java --version
```

## 📁 Project Structure

```
clean-code/
└── src/main/java/com/cleancode/
    ├── domain/
    ├── bloaters/
    │   ├── longmethod/
    │   └── longparameterlist/
    ├── objectorientedabusers/
    │   └── switchstatements/
    ├── changepreventers/
    ├── dispensables/
    ├── couplers/
    └── Main.java
```

**Code Smell Organization:**
- Each code smell has its own dedicated package
- Clear separation between problematic and refactored code
- Shared domain models in `com.cleancode.domain` package
- Comprehensive test coverage for each smell

## 🚀 Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/shift-elevate/clean-code.git
cd clean-code
```

### 2. Setup Environment (Automatic with SDKMAN)

The project includes a `.sdkmanrc` file that automatically configures Java 21 and Maven when you enter the directory:

```bash
# Activate the project environment (Java 21 + Maven)
sdk env

# This will automatically switch to:
# - Java 21.0.7-tem
# - Maven 3.9.10
```

### 3. Build the Project

```bash
mvn clean compile
```

### 4. Run the Main Application

```bash
mvn exec:java -Dexec.mainClass="com.cleancode.Main"
```

This will launch the main demonstration showing all implemented code smells and their refactored solutions.

## 📚 Running Instructions

### 🎯 **Recommended: Run Main Application for Complete Demo**

The best way to see all code smells and refactoring solutions in action:

```bash
# Run the main application with all demonstrations
mvn exec:java -Dexec.mainClass="com.cleancode.Main"

# Or compile and run directly
mvn clean compile
java -cp target/classes com.cleancode.Main
```

### 📦 **Advanced: Build and Run JAR**

For standalone execution:

```bash
# Build executable JAR
mvn clean package

# Run the JAR
java -jar target/clean-code-java-1.0.0.jar
```

## 🧪 Testing

### **Run All Tests**

```bash
mvn test
```

### **Run Specific Test Class**

```bash
# Long Method Code Smell
mvn test -Dtest=LongMethodTest

# Long Parameter List Code Smell
mvn test -Dtest=LongParameterListTest

# Switch Statements Code Smell
mvn test -Dtest=SwitchStatementsTest
```

## 🐛 Troubleshooting

### **Common Issues**

**Java Version Issues**:
```bash
# Check Java version
java --version

# Ensure Java 21 is active
sdk current java
```

**Maven Compilation Issues**:
```bash
# Clean and rebuild
mvn clean compile

# Skip tests if needed
mvn compile -DskipTests
```

**Class Path Issues**:
```bash
# Ensure proper classpath when running
java -cp target/classes com.cleancode.Main
```
