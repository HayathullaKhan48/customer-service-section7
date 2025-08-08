package com.customer.service.section7.service.impl;

import com.customer.service.section7.entity.CustomerModel;
import com.customer.service.section7.enums.CustomerStatus;
import com.customer.service.section7.mapper.CustomerMapper;
import com.customer.service.section7.repository.CustomerRepository;
import com.customer.service.section7.request.CustomerRequest;
import com.customer.service.section7.response.CustomerResponse;
import com.customer.service.section7.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation class for handling business logic related to customer operations.
 * This class contains the core logic for creating, retrieving, updating, and deleting customers.
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    // Injected CustomerRepository to interact with the database
    private final CustomerRepository customerRepository;

    /**
     * Creates a new customer by mapping the request to entity,
     * saving to DB, and returning the response DTO.
     */
    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        CustomerModel model = CustomerMapper.customerModel(request);
        CustomerModel saved = customerRepository.save(model);
        return CustomerMapper.customerResponse(saved);
    }

    /**
     * Fetches all customers from the database and returns them as a list of response DTOs.
     */
    @Override
    public List<CustomerResponse> getAllCustomersData() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::customerResponse)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a customer based on mobile number.
     *
     * @param mobileNumber The customer's mobile number
     * @return The response DTO
     */
    @Override
    public CustomerResponse getByCustomerMobileNumber(String mobileNumber) {
        CustomerModel model = customerRepository.findByCustomerMobileNumber(mobileNumber);
        return CustomerMapper.customerResponse(model);
    }

    /**
     * Retrieves a customer based on their username.
     *
     * @param name The customer's username
     * @return The response DTO
     */
    @Override
    public CustomerResponse getByCustomerName(String name) {
        CustomerModel model = customerRepository.findByUserName(name);
        return CustomerMapper.customerResponse(model);
    }

    /**
     * Retrieves a customer based on their email address.
     *
     * @param email The customer's email
     * @return The response DTO
     */
    @Override
    public CustomerResponse getByEmailAddress(String email) {
        CustomerModel model = customerRepository.findByCustomerEmailAddress(email);
        return CustomerMapper.customerResponse(model);
    }

    /**
     * Updates customer details based on their mobile number.
     * Fields updated: username, age, address, email.
     * The Updated date is also set.
     */
    @Override
    public CustomerResponse updateCustomer(CustomerRequest request) {
        CustomerModel model = customerRepository.findByCustomerMobileNumber(request.getCustomerMobileNumber());
        model.setUserName(request.getUserName());
        model.setCustomerAge(request.getCustomerAge());
        model.setCustomerAddress(request.getCustomerAddress());
        model.setCustomerEmailAddress(request.getCustomerEmailAddress());
        model.setUpdatedDate(LocalDateTime.now());
        return CustomerMapper.customerResponse(customerRepository.save(model));
    }

    /**
     * Soft deletes a customer by marking their status as INACTIVE instead of removing the record.
     *
     * @param mobile Customer's mobile number
     * @return Updated customer response with INACTIVE status
     */
    @Override
    public CustomerResponse deleteCustomer(String mobile) {
        CustomerModel model = customerRepository.findByCustomerMobileNumber(mobile);
        model.setUserStatus(CustomerStatus.INACTIVE);
        model.setUpdatedDate(LocalDateTime.now());
        return CustomerMapper.customerResponse(customerRepository.save(model));
    }

    /**
     * Updates a customer's mobile number based on their ID.
     *
     * @param id           Customer ID
     * @param mobileNumber New mobile number
     * @return Updated customer response
     */
    @Override
    public CustomerResponse updateMobileNumber(Long id, String mobileNumber) {
        CustomerModel model = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
        model.setCustomerMobileNumber(mobileNumber);
        model.setUpdatedDate(LocalDateTime.now());
        CustomerModel updatedModel = customerRepository.save(model);
        return CustomerMapper.customerResponse(updatedModel);
    }

}