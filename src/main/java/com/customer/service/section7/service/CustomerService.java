package com.customer.service.section7.service;

import com.customer.service.section7.request.CustomerRequest;
import com.customer.service.section7.response.CustomerResponse;

import java.util.List;

/**
 * CustomerService defines the contract for all customer-related operations.
 * It is implemented by the CustomerServiceImpl class and used by the controller layer
 * to delegate business logic.
 */
public interface CustomerService {

    /**
     * Creates a new customer in the system.
     *
     * @param request the customer details from the request body
     * @return the created customer's full response
     */
    CustomerResponse createCustomer(CustomerRequest request);

    /**
     * Retrieves all customer records from the system.
     *
     * @return a list of all customers as response DTOs
     */
    List<CustomerResponse> getAllCustomersData();

    /**
     * Retrieves a customer based on their mobile number.
     *
     * @param customerMobileNumber the mobile number to search for
     * @return the customer response if found
     */
    CustomerResponse getByCustomerMobileNumber(String customerMobileNumber);

    /**
     * Retrieves a customer based on their username.
     *
     * @param name the username of the customer
     * @return the customer response if found
     */
    CustomerResponse getByCustomerName(String name);

    /**
     * Retrieves a customer based on their email address.
     *
     * @param email the email address of the customer
     * @return the customer response if found
     */
    CustomerResponse getByEmailAddress(String email);

    /**
     * Updates the details of an existing customer.
     * The update is performed based on the mobile number provided in the request.
     *
     * @param request the updated customer details
     * @return the updated customer's response
     */
    CustomerResponse updateCustomer(CustomerRequest request);

    /**
     * Performs a soft delete by marking the customer's status as INACTIVE,
     * based on their mobile number.
     *
     * @param mobile the mobile number of the customer to deactivate
     * @return the updated customer response with status INACTIVE
     */
    CustomerResponse deleteCustomer(String mobile);

    /**
     * Updates the customer's mobile number using their unique ID.
     *
     * @param id           the customer ID
     * @param MobileNumber the new mobile number to be updated
     * @return the updated customer's response
     */
    CustomerResponse updateMobileNumber(Long id, String MobileNumber);
}
