package com.cleancode;

import com.cleancode.bloaters.longmethod.LongMethodSmell;
import com.cleancode.bloaters.longmethod.LongMethodRefactored;
import com.cleancode.objectorientedabusers.switchstatements.SwitchStatementsSmell;
import com.cleancode.objectorientedabusers.switchstatements.SwitchStatementsRefactored;
import com.cleancode.domain.Customer;
import com.cleancode.domain.Order;
import com.cleancode.domain.OrderItem;

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
        
        demonstrateSwitchStatementsCodeSmell();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        demonstrateSwitchStatementsRefactored();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
    }
    
    /**
     * Demonstrates the Long Method code smell.
     */
    private static void demonstrateLongMethodCodeSmell() {
        System.out.println("🐛 LONG METHOD CODE SMELL");

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
    }
    
    /**
     * Demonstrates the refactored solution using Extract Method.
     */
    private static void demonstrateLongMethodRefactored() {
        System.out.println("✅ LONG METHOD REFACTORED");

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
    }
    

    
    /**
     * Demonstrates the Switch Statements code smell.
     */
    private static void demonstrateSwitchStatementsCodeSmell() {
        System.out.println("🐛 SWITCH STATEMENTS CODE SMELL");
        
        SwitchStatementsSmell processor = new SwitchStatementsSmell();
        
        System.out.println("Processing Regular Customer:");
        processor.processCustomer("REGULAR", 100.0);
        
        System.out.println("\nProcessing Premium Customer:");
        processor.processCustomer("PREMIUM", 200.0);
        
        System.out.println("\nProcessing VIP Customer:");
        processor.processCustomer("VIP", 300.0);
    }
    
    /**
     * Demonstrates the refactored solution using Replace Conditional with Polymorphism.
     */
    private static void demonstrateSwitchStatementsRefactored() {
        System.out.println("✅ SWITCH STATEMENTS REFACTORED");
        
        SwitchStatementsRefactored processor = new SwitchStatementsRefactored();
        
        System.out.println("Processing Regular Customer:");
        SwitchStatementsRefactored.RegularCustomer regularCustomer = new SwitchStatementsRefactored.RegularCustomer("John Doe");
        processor.processCustomer(regularCustomer, 100.0);
        
        System.out.println("\nProcessing Premium Customer:");
        SwitchStatementsRefactored.PremiumCustomer premiumCustomer = new SwitchStatementsRefactored.PremiumCustomer("Jane Smith");
        processor.processCustomer(premiumCustomer, 200.0);
        
        System.out.println("\nProcessing VIP Customer:");
        SwitchStatementsRefactored.VipCustomer vipCustomer = new SwitchStatementsRefactored.VipCustomer("Bob Wilson");
        processor.processCustomer(vipCustomer, 300.0);
    }
}
