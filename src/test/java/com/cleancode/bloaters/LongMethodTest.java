package com.cleancode.bloaters;

import com.cleancode.bloaters.longmethod.LongMethodSmell;
import com.cleancode.bloaters.longmethod.LongMethodRefactored;
import com.cleancode.domain.Customer;
import com.cleancode.domain.Order;
import com.cleancode.domain.OrderItem;
import com.cleancode.domain.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Long Method Code Smell Tests")
class LongMethodTest {
    
    private LongMethodSmell longMethodSmell;
    private LongMethodRefactored longMethodRefactored;
    
    @BeforeEach
    void setUp() {
        longMethodSmell = new LongMethodSmell();
        longMethodRefactored = new LongMethodRefactored();
    }
    
    @Nested
    @DisplayName("Long Method Smell Tests")
    class LongMethodSmellTests {
        
        @Test
        @DisplayName("Should process order with multiple responsibilities in one method")
        void shouldProcessOrderWithMultipleResponsibilities() {
            Customer customer = new Customer("C001", "John Doe", "john@example.com", false);
            Order order = new Order("O001", customer);
            order.addItem(new OrderItem("P001", "Laptop", 999.99, 1));
            order.addItem(new OrderItem("P002", "Mouse", 29.99, 2));
            
            longMethodSmell.processOrder(order);
            
            assertEquals(1006.97, order.getTotal(), 0.01);
            assertEquals(OrderStatus.PROCESSED, order.getStatus());
        }
        
        @Test
        @DisplayName("Should apply premium customer discount")
        void shouldApplyPremiumCustomerDiscount() {
            Customer premiumCustomer = new Customer("C002", "Jane Smith", "jane@example.com", true);
            Order order = new Order("O002", premiumCustomer);
            order.addItem(new OrderItem("P003", "Monitor", 299.99, 1));
            
            longMethodSmell.processOrder(order);
            
            assertEquals(256.49, order.getTotal(), 0.01);
        }
        
        @Test
        @DisplayName("Should apply bulk order discount")
        void shouldApplyBulkOrderDiscount() {
            Customer customer = new Customer("C003", "Bob Wilson", "bob@example.com", false);
            Order order = new Order("O003", customer);
            order.addItem(new OrderItem("P004", "Gaming PC", 1200.00, 1));
            
            longMethodSmell.processOrder(order);
            
            assertEquals(1140.00, order.getTotal(), 0.01);
        }
        
        @Test
        @DisplayName("Should apply both premium and bulk discounts")
        void shouldApplyBothDiscounts() {
            Customer premiumCustomer = new Customer("C004", "Alice Brown", "alice@example.com", true);
            Order order = new Order("O004", premiumCustomer);
            order.addItem(new OrderItem("P005", "Workstation", 1500.00, 1));
            
            longMethodSmell.processOrder(order);
            
            assertEquals(1282.50, order.getTotal(), 0.01);
        }
        
        @Test
        @DisplayName("Should throw exception for null order")
        void shouldThrowExceptionForNullOrder() {
            assertThrows(IllegalArgumentException.class, () -> {
                longMethodSmell.processOrder(null);
            });
        }
        
        @Test
        @DisplayName("Should throw exception for empty order")
        void shouldThrowExceptionForEmptyOrder() {
            Customer customer = new Customer("C005", "Test User", "test@example.com", false);
            Order order = new Order("O005", customer);
            
            assertThrows(IllegalArgumentException.class, () -> {
                longMethodSmell.processOrder(order);
            });
        }
        
        @Test
        @DisplayName("Should throw exception for order without customer")
        void shouldThrowExceptionForOrderWithoutCustomer() {
            Order order = new Order("O006", null);
            order.addItem(new OrderItem("P006", "Product", 100.00, 1));
            
            assertThrows(IllegalArgumentException.class, () -> {
                longMethodSmell.processOrder(order);
            });
        }
    }
    
    @Nested
    @DisplayName("Long Method Refactored Tests")
    class LongMethodRefactoredTests {
        
        @Test
        @DisplayName("Should process order with same functionality as smell version")
        void shouldProcessOrderWithSameFunctionality() {
            Customer customer = new Customer("C007", "John Doe", "john@example.com", false);
            Order order = new Order("O007", customer);
            order.addItem(new OrderItem("P007", "Laptop", 999.99, 1));
            order.addItem(new OrderItem("P008", "Mouse", 29.99, 2));
            
            longMethodRefactored.processOrder(order);
            
            assertEquals(1006.97, order.getTotal(), 0.01);
            assertEquals(OrderStatus.PROCESSED, order.getStatus());
        }
        
        @Test
        @DisplayName("Should apply premium customer discount correctly")
        void shouldApplyPremiumCustomerDiscount() {
            Customer premiumCustomer = new Customer("C008", "Jane Smith", "jane@example.com", true);
            Order order = new Order("O008", premiumCustomer);
            order.addItem(new OrderItem("P009", "Monitor", 299.99, 1));
            
            longMethodRefactored.processOrder(order);
            
            assertEquals(256.49, order.getTotal(), 0.01);
        }
        
        @Test
        @DisplayName("Should apply bulk order discount correctly")
        void shouldApplyBulkOrderDiscount() {
            Customer customer = new Customer("C009", "Bob Wilson", "bob@example.com", false);
            Order order = new Order("O009", customer);
            order.addItem(new OrderItem("P010", "Gaming PC", 1200.00, 1));
            
            longMethodRefactored.processOrder(order);
            
            assertEquals(1140.00, order.getTotal(), 0.01);
        }
        
        @Test
        @DisplayName("Should apply both premium and bulk discounts correctly")
        void shouldApplyBothDiscounts() {
            Customer premiumCustomer = new Customer("C010", "Alice Brown", "alice@example.com", true);
            Order order = new Order("O010", premiumCustomer);
            order.addItem(new OrderItem("P011", "Workstation", 1500.00, 1));
            
            longMethodRefactored.processOrder(order);
            
            assertEquals(1282.50, order.getTotal(), 0.01);
        }
        
        @Test
        @DisplayName("Should throw exception for null order")
        void shouldThrowExceptionForNullOrder() {
            assertThrows(IllegalArgumentException.class, () -> {
                longMethodRefactored.processOrder(null);
            });
        }
        
        @Test
        @DisplayName("Should throw exception for empty order")
        void shouldThrowExceptionForEmptyOrder() {
            Customer customer = new Customer("C011", "Test User", "test@example.com", false);
            Order order = new Order("O011", customer);
            
            assertThrows(IllegalArgumentException.class, () -> {
                longMethodRefactored.processOrder(order);
            });
        }
        
        @Test
        @DisplayName("Should throw exception for order without customer")
        void shouldThrowExceptionForOrderWithoutCustomer() {
            Order order = new Order("O012", null);
            order.addItem(new OrderItem("P012", "Product", 100.00, 1));
            
            assertThrows(IllegalArgumentException.class, () -> {
                longMethodRefactored.processOrder(order);
            });
        }
    }
}
