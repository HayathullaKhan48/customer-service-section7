package com.customer.service.section7.request;

import lombok.*;

/**
 * CustomerRequest is a DTO (Data Transfer Object) used to receive data from the client
 * when creating or updating a customer. It acts as an input model in the request body.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {
    public Long id;
    private String userName;
    private int customerAge;
    private String customerMobileNumber;
    private String customerEmailAddress;
    private String customerAddress;
}
