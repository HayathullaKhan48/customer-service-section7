package com.customer.service.section7.entity;

import com.customer.service.section7.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Entity class representing customer details.
 * This maps to the "customer_details_section7" table in the database.
 * It uses JPA annotations for ORM mapping and Lombok annotations for boilerplate code reduction.
 */
@Entity
@Table(name = "customer_details_section7")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "userName")
    private String userName;

    @Column(name = "customerAge")
    private Integer customerAge;

    @Column(name = "customerMobileNumber", unique = true)
    private String customerMobileNumber;

    @Column(name = "customerEmailAddress", unique = true)
    private String customerEmailAddress;

    @Column(name = "customerAddress")
    private String customerAddress;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "userStatus")
    private CustomerStatus userStatus;

    @Column(name = "createdDate")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "updatedDate")
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}