package com.customer.service.section7.controller;

import com.customer.service.section7.request.CustomerRequest;
import com.customer.service.section7.response.CustomerResponse;
import com.customer.service.section7.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CustomerController handles all incoming HTTP requests related to customer operations.
 * It maps each endpoint to a specific service method to perform business logic.
 */
@RestController
@RequestMapping("/api/customer/v1")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Create a new customer.
     * Endpoint: POST /api/customer/v1/create
     *
     * @param request - Request body containing customer details
     * @return Created customer response
     */
    @PostMapping("/create")
    public CustomerResponse createCustomer(@RequestBody CustomerRequest request) {
        return customerService.createCustomer(request);
    }

    /**
     * Get all customer records.
     * Endpoint: GET /api/customer/v1/getAllData
     *
     * @return List of all customers
     */
    @GetMapping("/getAllData")
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomersData();
    }

    /**
     * Get a customer by mobile number.
     * Endpoint: GET /api/customer/v1/getBy/customerMobileNumber/{mobileNumber}
     *
     * @param mobileNumber - Customer's mobile number
     * @return Customer details matching the mobile number
     */
    @GetMapping("/getBy/customerMobileNumber/{mobileNumber}")
    public CustomerResponse getByMobile(@PathVariable String mobileNumber) {
        return customerService.getByCustomerMobileNumber(mobileNumber);
    }

    /**
     * Get a customer by username.
     * Endpoint: GET /api/customer/v1/getBy/UserName/{userName}
     *
     * @param userName - Customer's username
     * @return Customer details matching the username
     */
    @GetMapping("/getBy/UserName/{userName}")
    public CustomerResponse getByUserName(@PathVariable String userName) {
        return customerService.getByCustomerName(userName);
    }

    /**
     * Get a customer by email address.
     * Endpoint: GET /api/customer/v1/getBy/emailAddress/{emailAddress}
     *
     * @param emailAddress - Customer's email address
     * @return Customer details matching the email address
     */
    @GetMapping("/getBy/emailAddress/{emailAddress}")
    public CustomerResponse getByEmail(@PathVariable String emailAddress) {
        return customerService.getByEmailAddress(emailAddress);
    }

    /**
     * Update an existing customer by matching mobile number.
     * Endpoint: PUT /api/customer/v1/update
     *
     * @param request - Request body with updated customer data
     * @return Updated customer response
     */
    @PutMapping("/update")
    public CustomerResponse updateCustomer(@RequestBody CustomerRequest request) {
        return customerService.updateCustomer(request);
    }

    /**
     * Softly delete a customer by setting status to INACTIVE using mobile number.
     * Endpoint: DELETE /api/customer/v1/delete/{mobileNumber}
     *
     * @param mobileNumber - Mobile number of customers to be deleted
     * @return Customer response with status updated to INACTIVE
     */
    @DeleteMapping("/delete/{mobileNumber}")
    public CustomerResponse deleteCustomer(@PathVariable String mobileNumber) {
        return customerService.deleteCustomer(mobileNumber);
    }

    /**
     * Update customer's mobile number using their ID.
     * Endpoint: PATCH /api/customer/v1/updateMobileNumber/{id}/{mobileNumber}
     *
     * @param id           - Customer ID
     * @param mobileNumber - New mobile number to be updated
     * @return Updated customer response
     */
    @PatchMapping("updateMobileNumber/{id}/{mobileNumber}")
    public CustomerResponse updateMobileNumber(@PathVariable Long id, @PathVariable String mobileNumber) {
        return customerService.updateMobileNumber(id, mobileNumber);
    }

}