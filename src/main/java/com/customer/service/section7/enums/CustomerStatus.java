package com.customer.service.section7.enums;

/**
 * Enum representing the status of a customer.
 * <p>
 * - ACTIVE: Indicates that the customer is currently active in the system.
 * - INACTIVE: Indicates that the customer has been deactivated (soft delete).
 * <p>
 * This enum is stored in the database using its string name (e.g., "ACTIVE", "INACTIVE")
 * through @Enumerated(EnumType.STRING) in the entity.
 */
public enum CustomerStatus {
    ACTIVE,
    INACTIVE
}