package com.customer.service.section7.mapper;

import com.customer.service.section7.entity.CustomerModel;
import com.customer.service.section7.enums.CustomerStatus;
import com.customer.service.section7.request.CustomerRequest;
import com.customer.service.section7.response.CustomerResponse;
import com.customer.service.section7.util.CustomerUtil;

import java.time.LocalDateTime;

/**
 * The CustomerMapper class is responsible for converting between
 * CustomerRequest <--> CustomerModel and CustomerModel <--> CustomerResponse.
 * <p>
 * This ensures a clean separation between API layer (DTOs) and persistence layer (Entity).
 */
public class CustomerMapper {

    /**
     * Converts a CustomerRequest object (from API input) to a CustomerModel object (entity).
     *
     * @param request the input data from the client
     * @return a fully constructed CustomerModel with encrypted password, default ACTIVE status,
     * and timestamps for createdDate and updatedDate.
     */
    public static CustomerModel customerModel(CustomerRequest request) {
        return CustomerModel.builder()
                .userName(request.getUserName())
                .customerAge(request.getCustomerAge())
                .customerMobileNumber(request.getCustomerMobileNumber())
                .customerEmailAddress(request.getCustomerEmailAddress())
                .customerAddress(request.getCustomerAddress())
                .password(CustomerUtil.hashPassword(request.getPassword()))
                .userStatus(CustomerStatus.ACTIVE)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }

    /**
     * Converts a CustomerModel object (entity) to a CustomerResponse object (API output).
     *
     * @param model the entity from the database
     * @return a CustomerResponse that includes all fields except the password
     */
    public static CustomerResponse customerResponse(CustomerModel model) {
        return CustomerResponse.builder()
                .customerId(model.getCustomerId())
                .userName(model.getUserName())
                .customerAge(model.getCustomerAge())
                .customerMobileNumber(model.getCustomerMobileNumber())
                .customerEmailAddress(model.getCustomerEmailAddress())
                .customerAddress(model.getCustomerAddress())
                .userStatus(model.getUserStatus())
                .createdDate(model.getCreatedDate())
                .updatedDate(model.getUpdatedDate())
                .build();
    }
}
