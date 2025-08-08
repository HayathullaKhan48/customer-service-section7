package com.customer.service.section7.response;

import com.customer.service.section7.enums.CustomerStatus;
import lombok.*;

import java.time.LocalDateTime;

/**
 * CustomerResponse is a DTO (Data Transfer Object) used to send customer details
 * back to the client after performing operations like create, update, delete, etc.
 * <p>
 * This class holds the necessary output fields to be shown in API responses.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private Long customerId;
    private String userName;
    private Integer customerAge;
    private String customerEmailAddress;
    private String customerMobileNumber;
    private String customerAddress;
    private CustomerStatus userStatus;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}