# Customer Service Section7

A Spring Boot microservice to manage customer data securely, 
following a clean layered architecture and including features like password hashing, 
enum-based status, and timestamp management.

---

##  Features

* RESTful API endpoints
* Encrypted password storage using SHA-256
* Enum-based status (`ACTIVE`, `INACTIVE`)
* Auto-managed creation and update timestamps
* Clean multi-layered architecture
* Spring Data JPA for database interaction
* MySQL integration
* Modular codebase with DTOs, utility classes, constants, and enums
* `Lombok` for boilerplate reduction

---

##  Tech Stack

* Spring Boot
* Spring Web
* Spring Data JPA
* Lombok
* MySQL
* Java 17+

---

##  API Endpoints

### 1. **Create Customer**

* **Method**: `POST`
* **URL**: `http://localhost:8080/api/customer/v1/create`
* **Request Body**:

```json
{
  "userName": "Arzoo3",
  "customerAge": 18,
  "customerMobileNumber": "9985415003",
  "customerEmailAddress": "Arzo15@gmail.com",
  "customerAddress": "Chinnamandem"
}
```

* **Response Body**: 
```json
{
  "code": 201,
  "message": "CREATED",
  "data": {
            "customerId": 7,
            "userName": "Arzoo3",
            "customerAge": 18,
            "customerEmailAddress": "Arzo15@gmail.com",
            "customerMobileNumber": "9985415003",
            "customerAddress": "Chinnamandem",
            "userStatus": "ACTIVE",
            "createdDate": "2025-08-08T17:19:09.408136",
            "updatedDate": "2025-08-08T17:19:09.408136"
  }
}
```
---

### 2. **Get All Customers**

* **Method**: `GET`
* **URL**: `http://localhost:8080/api/customer/v1/getAllData`
* **Response Body**:
```json
[
  {
    "customerId": 1,
    "userName": "Hayath",
    "customerAge": 25,
    "customerEmailAddress": "hayath@gmail.com",
    "customerMobileNumber": "1234567890",
    "customerAddress": "Chinnamandem",
    "userStatus": "ACTIVE",
    "createdDate": "2025-08-07T21:19:54.298854",
    "updatedDate": "2025-08-08T13:20:34.735257"
  },
  {
    "customerId": 2,
    "userName": "sufiyan",
    "customerAge": 25,
    "customerEmailAddress": "sufiyan@gmail.com",
    "customerMobileNumber": "9876543210",
    "customerAddress": "Chinnamandem",
    "userStatus": "ACTIVE",
    "createdDate": "2025-08-08T10:45:29.131968",
    "updatedDate": "2025-08-08T10:45:29.131968"
  },
  {
    "customerId": 3,
    "userName": "ArzooUpdate",
    "customerAge": 18,
    "customerEmailAddress": "Arzoo@gmail.com",
    "customerMobileNumber": "8985415771",
    "customerAddress": "Chinnamandem",
    "userStatus": "INACTIVE",
    "createdDate": "2025-08-08T10:46:22.031148",
    "updatedDate": "2025-08-08T15:50:34.712948"
  },
  {
    "customerId": 4,
    "userName": "akif",
    "customerAge": 3,
    "customerEmailAddress": "akif@gmail.com",
    "customerMobileNumber": "0987654321",
    "customerAddress": "madanapalle",
    "userStatus": "ACTIVE",
    "createdDate": "2025-08-08T12:04:39.342463",
    "updatedDate": "2025-08-08T13:21:04.223769"
  },
  {
    "customerId": 5,
    "userName": "Arzoo1",
    "customerAge": 18,
    "customerEmailAddress": "Arzo1o@gmail.com",
    "customerMobileNumber": "8985415001",
    "customerAddress": "Chinnamandem",
    "userStatus": "ACTIVE",
    "createdDate": "2025-08-08T16:08:55.884563",
    "updatedDate": "2025-08-08T16:08:55.884563"
  },
  {
    "customerId": 6,
    "userName": "Arzoo2",
    "customerAge": 18,
    "customerEmailAddress": "Arzo13@gmail.com",
    "customerMobileNumber": "8985415003",
    "customerAddress": "Chinnamandem",
    "userStatus": "ACTIVE",
    "createdDate": "2025-08-08T16:22:48.928143",
    "updatedDate": "2025-08-08T16:22:48.928143"
  }
]
```

---

### 3. **Get Customer By Mobile Number**

* **Method**: `GET`
* **URL**: `http://localhost:8080/api/customer/v1/getBy/customerMobileNumber/8985415771`
* **Response**: 
```json
{
    "customerId": 3,
    "userName": "Arzoo",
    "customerAge": 18,
    "customerEmailAddress": "Arzoo@gmail.com",
    "customerMobileNumber": "8985415771",
    "customerAddress": "Chinnamandem",
    "userStatus": "INACTIVE",
    "createdDate": "2025-08-08T10:46:22.031148",
    "updatedDate": "2025-08-08T11:47:02.11781"
}
```

---

### 4. **Get Customer By Username**

* **Method**: `GET`
* **URL**: `http://localhost:8080/api/customer/v1/getBy/UserName/Hayath`
```json
{
    "customerId": 1,
    "userName": "Hayath",
    "customerAge": 25,
    "customerEmailAddress": "hayath@gmail.com",
    "customerMobileNumber": "1234567890",
    "customerAddress": "Chinnamandem",
    "userStatus": "ACTIVE",
    "createdDate": "2025-08-07T21:19:54.298854",
    "updatedDate": "2025-08-08T13:20:34.735257"
}
```

---

### 5. **Get Customer By Email Address**

* **Method**: `GET`
* **URL**: `http://localhost:8080/api/customer/v1/getBy/emailAddress/akif@gmail.com`
```json
{
    "customerId": 4,
    "userName": "akif",
    "customerAge": 3,
    "customerEmailAddress": "akif@gmail.com",
    "customerMobileNumber": "1234567890",
    "customerAddress": "madanapalle",
    "userStatus": "ACTIVE",
    "createdDate": "2025-08-08T12:04:39.342463",
    "updatedDate": "2025-08-08T12:09:13.087954"
}
```

---

### 6. **Update Customer Details**

* **Method**: `PUT`
* **URL**: `http://localhost:8080/api/customer/v1/update`
* **Request Body**:

```json
{
  "customerId": 3,
  "userName": "Arzoo",
  "customerAge": 18,
  "customerEmailAddress": "Arzoo@gmail.com",
  "customerMobileNumber": "8985415771",
  "customerAddress": "Chinnamandem",
  "userStatus": "ACTIVE",
  "createdDate": "2025-08-08T10:46:22.031148",
  "updatedDate": "2025-08-08T15:50:34.712948"
}
```

* **Response Body**:
```json
{
    "customerId": 3,
    "userName": "ArzooUpdate",
    "customerAge": 18,
    "customerEmailAddress": "Arzoo@gmail.com",
    "customerMobileNumber": "000000000",
    "customerAddress": "Chinnamandem",
    "userStatus": "ACTIVE",
    "createdDate": "2025-08-08T10:46:22.031148",
    "updatedDate": "2025-08-08T15:50:34.712948"
}
```

---

### 7. **Delete Customer (Soft Delete)**

* **Method**: `DELETE`
* **URL**: `http://localhost:8080/api/customer/v1/delete/8985415771`
* **Response Body**: `
```json
{
    "customerId": 3,
    "userName": "Arzoo",
    "customerAge": 18,
    "customerEmailAddress": "Arzoo@gmail.com",
    "customerMobileNumber": "8985415771",
    "customerAddress": "Chinnamandem",
    "userStatus": "INACTIVE",
    "createdDate": "2025-08-08T10:46:22.031148",
    "updatedDate": "2025-08-08T13:09:26.710121"
}
```

---

### 8. **Patch Mobile Number**

* **Method**: `PATCH`
* **URL**: `http://localhost:8080/api/customer/v1/updateMobileNumber/4/0987654321`
* **Response Body**: 
```json
{
    "customerId": 4,
    "userName": "akif",
    "customerAge": 3,
    "customerEmailAddress": "akif@gmail.com",
    "customerMobileNumber": "0987654321",
    "customerAddress": "madanapalle",
    "userStatus": "ACTIVE",
    "createdDate": "2025-08-08T12:04:39.342463",
    "updatedDate": "2025-08-08T13:21:04.223769"
}
```

---

##  Database Schema

**Table**: `customer_details_section7`

| Field Name     | Type      | Description                  |
|----------------|-----------|------------------------------|
| id             | bigint    | Primary Key (Auto-generated) |
| user\_name     | varchar   | Customer name                |
| mobile\_number | varchar   | Customer mobile number       |
| email\_address | varchar   | Customer email               |
| customer\_age  | int       | Customer age                 |
| password       | varchar   | Encrypted password           |
| user\_status   | varchar   | Enum: `ACTIVE`, `INACTIVE`   |
| created\_date  | timestamp | Record creation timestamp    |
| updated\_date  | timestamp | Last update timestamp        |

---

##  Password Hashing

* Passwords are auto-generated and hashed using **SHA-256** before saving.
* Format: 10 characters with at least 1 uppercase, lowercase, digit, and special character.

---

##  Project Structure

```
customer-service-section7
|── constant               # Constants like password characters, length
|── controller             # REST controllers for endpoints
|── enums                  # Enum for CustomerStatus
|── entity/model           # JPA Entity - CustomerModel
|── repository             # Spring Data JPA repository
|── request                # Request DTOs
|── response               # Response DTOs
|── service                # Interfaces and implementations
|── util                   # Utility class for password hashing
── CustomerServiceSection7Application.java
```

---

##  Enum - CustomerStatus

```java
public enum CustomerStatus {
    ACTIVE,
    INACTIVE
}
```

---

##  Important Classes & Purpose

| Class                 | Purpose                                   |
|-----------------------|-------------------------------------------|
| `CustomerController`  | Handles all REST API requests             |
| `CustomerService`     | Service interface for business logic      |
| `CustomerServiceImpl` | Implementation of business logic          |
| `CustomerModel`       | Entity class for JPA table mapping        |
| `CustomerRequest`     | DTO for input requests                    |
| `CustomerResponse`    | DTO for output responses                  |
| `CustomerUtil`        | Utility for password generation & hashing |
| `Constant`            | Constant values used across application   |
| `CustomerRepository`  | Extends `JpaRepository` for DB operations |

---

##  How to Run

1. Create database:

   ```sql
   CREATE DATABASE customer_db7;
   ```
2. Update `application.properties` with MySQL credentials.
3. Run Spring Boot Application.
4. Test using **Postman** or any REST client.

---

##  Future Enhancements
* Add input validation annotations (`@NotNull`, `@Email`, etc.)
* Centralized global exception handling
* Add JWT-based authentication
* Full Swagger/OpenAPI documentation
* Implement pagination for `getAllData`

---