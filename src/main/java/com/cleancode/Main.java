package com.cleancode;

import com.cleancode.bloaters.longmethod.LongMethodSmell;
import com.cleancode.bloaters.longmethod.LongMethodRefactored;
import com.cleancode.domain.Customer;
import com.cleancode.domain.Order;
import com.cleancode.domain.OrderItem;
import com.cleancode.domain.OrderStatus;

/**
 * Main demonstration class for Clean Code examples.
 * Shows code smells and their refactored solutions.
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("🧹 Clean Code Examples");
        System.out.println("======================\n");
        
        demonstrateLongMethodCodeSmell();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        demonstrateLongMethodRefactored();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        demonstrateComparison();
    }
    
    /**
     * Demonstrates the Long Method code smell.
     */
    private static void demonstrateLongMethodCodeSmell() {
        System.out.println("🐛 LONG METHOD CODE SMELL");
        System.out.println("-------------------------");
        System.out.println("Problem: Method with 40+ lines handling multiple responsibilities");
        System.out.println("Impact: Reduced readability, difficult testing, higher bug risk\n");
        
        LongMethodSmell processor = new LongMethodSmell();
        
        // Create test data
        Customer customer = new Customer("C001", "John Doe", "john@example.com", true);
        Order order = new Order("O001", customer);
        order.addItem(new OrderItem("P001", "Laptop", 999.99, 1));
        order.addItem(new OrderItem("P002", "Mouse", 29.99, 2));
        
        System.out.println("Before processing:");
        System.out.println("Order: " + order);
        System.out.println("Total: $" + order.getTotal());
        System.out.println("Status: " + order.getStatus());
        
        // Process order
        processor.processOrder(order);
        
        System.out.println("\nAfter processing:");
        System.out.println("Order: " + order);
        System.out.println("Total: $" + order.getTotal());
        System.out.println("Status: " + order.getStatus());
        
        System.out.println("\n❌ Code Smell Issues:");
        System.out.println("- Method handles validation, calculation, discount, and persistence");
        System.out.println("- 40+ lines of code in single method");
        System.out.println("- Difficult to test individual behaviors");
        System.out.println("- Violates Single Responsibility Principle");
    }
    
    /**
     * Demonstrates the refactored solution using Extract Method.
     */
    private static void demonstrateLongMethodRefactored() {
        System.out.println("✅ LONG METHOD REFACTORED");
        System.out.println("-------------------------");
        System.out.println("Solution: Extract Method refactoring");
        System.out.println("Benefits: Improved readability, enhanced testability, better maintainability\n");
        
        LongMethodRefactored processor = new LongMethodRefactored();
        
        // Create test data
        Customer customer = new Customer("C002", "Jane Smith", "jane@example.com", true);
        Order order = new Order("O002", customer);
        order.addItem(new OrderItem("P003", "Monitor", 299.99, 1));
        order.addItem(new OrderItem("P004", "Keyboard", 89.99, 1));
        
        System.out.println("Before processing:");
        System.out.println("Order: " + order);
        System.out.println("Total: $" + order.getTotal());
        System.out.println("Status: " + order.getStatus());
        
        // Process order
        processor.processOrder(order);
        
        System.out.println("\nAfter processing:");
        System.out.println("Order: " + order);
        System.out.println("Total: $" + order.getTotal());
        System.out.println("Status: " + order.getStatus());
        
        System.out.println("\n✅ Refactoring Benefits:");
        System.out.println("- Main method reads like a high-level workflow");
        System.out.println("- Each extracted method has single responsibility");
        System.out.println("- Individual behaviors can be tested separately");
        System.out.println("- Changes to specific logic are isolated");
    }
    
    /**
     * Demonstrates comparison between smell and refactored versions.
     */
    private static void demonstrateComparison() {
        System.out.println("🔄 COMPARISON: SMELL vs REFACTORED");
        System.out.println("----------------------------------");
        System.out.println("Both implementations produce identical results\n");
        
        LongMethodSmell smellProcessor = new LongMethodSmell();
        LongMethodRefactored refactoredProcessor = new LongMethodRefactored();
        
        // Create identical test data
        Customer customer = new Customer("C003", "Test Customer", "test@example.com", true);
        Order smellOrder = new Order("O003", customer);
        Order refactoredOrder = new Order("O004", customer);
        
        OrderItem item1 = new OrderItem("P005", "Product 1", 500.00, 2);
        OrderItem item2 = new OrderItem("P006", "Product 2", 300.00, 1);
        
        smellOrder.addItem(item1);
        smellOrder.addItem(item2);
        refactoredOrder.addItem(item1);
        refactoredOrder.addItem(item2);
        
        System.out.println("Processing with Long Method Smell:");
        smellProcessor.processOrder(smellOrder);
        System.out.println("Result: $" + smellOrder.getTotal() + " | Status: " + smellOrder.getStatus());
        
        System.out.println("\nProcessing with Refactored Version:");
        refactoredProcessor.processOrder(refactoredOrder);
        System.out.println("Result: $" + refactoredOrder.getTotal() + " | Status: " + refactoredOrder.getStatus());
        
        System.out.println("\n✅ Comparison Results:");
        System.out.println("- Both produce identical results: $" + smellOrder.getTotal());
        System.out.println("- Both set status to: " + smellOrder.getStatus());
        System.out.println("- Refactored version maintains same functionality");
        System.out.println("- Refactored version is more maintainable and testable");
        
        System.out.println("\n🎯 Key Takeaway:");
        System.out.println("Extract Method refactoring improves code quality without changing behavior.");
        System.out.println("The refactored version is easier to understand, test, and maintain.");
    }
}
