package com.cleancode.domain;

/**
 * Enum representing the status of an order in the e-commerce system.
 * Used to demonstrate code smells and refactoring techniques.
 */
public enum OrderStatus {
    PENDING,
    PROCESSED,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
