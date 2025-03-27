# E-commerce Customer API

## Overview
Spring Boot backend for managing customer accounts, order processing, and customer-related data in an e-commerce system.

## Features
✅ Customer registration & authentication  
✅ Order management  
✅ Customer data storage  
✅ RESTful API for seamless integration  

---

## 🏗️ Project Structure
```
src/
├── main/
│   ├── java/com/ecommerce/customer/
│   │   ├── entities/
│   │   │   ├── Customer.java
│   │   │   ├── Orders.java
│   │   │   ├── Products.java
│   │   ├── repositories/
│   │   │   ├── CustomerRepo.java
│   │   │   ├── OrdersRepo.java
│   │   │   ├── ProductsRepo.java
│   │   ├── services/
│   │   │   ├── CustomerService.java
│   │   │   ├── OrdersService.java
│   │   │   ├── ProductService.java
│   │   ├── controllers/
│   │   │   ├── AdminController.java
│   │   ├── application/
│   │   │   ├── EcommerceAdminApplication.java
│   ├── resources/
│   │   ├── application.properties
└── test/
```

---

## 🚀 API Endpoints
| Endpoint                | Method | Request Body            | Description |
|-------------------------|--------|-------------------------|-------------|
| `POST /customer/register` | POST   | `Customer`              | Register a new customer |
| `POST /customer/order`    | POST   | `Orders`                | Place a new order |
| `GET /customer/orders`     | GET    | `customerId` as param   | Retrieve customer orders |

---

## ⚙️ Setup
1. **Configure MySQL** in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

2. **Run the application**:
```bash
mvn spring-boot:run
```

---

## 📌 Tech Stack
- **Backend**: Spring Boot 3.3.5  
- **Database**: MySQL  
- **Authentication**: Basic authentication/session-based  
- **Build Tool**: Maven  

---

## 📄 License
MIT © 2024

