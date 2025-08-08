package com.customer.service.section7.repository;

import com.customer.service.section7.entity.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository is a Data Access Layer interface that interacts with the database
 * using Spring Data JPA. It extends JpaRepository to provide basic CRUD operations.
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    /**
     * Fetches a customer entity from the database using the mobile number.
     *
     * @param customerMobileNumber the mobile number of the customer
     * @return the CustomerModel if found, otherwise null
     */
    CustomerModel findByCustomerMobileNumber(String customerMobileNumber);

    /**
     * Fetches a customer entity from the database using the username.
     *
     * @param userName the username of the customer
     * @return the CustomerModel if found, otherwise null
     */
    CustomerModel findByUserName(String userName);

    /**
     * Fetches a customer entity from the database using the email address.
     *
     * @param customerEmailAddress the email address of the customer
     * @return the CustomerModel if found, otherwise null
     */
    CustomerModel findByCustomerEmailAddress(String customerEmailAddress);
}