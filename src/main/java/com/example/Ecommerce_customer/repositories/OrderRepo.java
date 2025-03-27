package com.example.Ecommerce_customer.repositories;

import com.example.Ecommerce_customer.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {
    List<Orders> findByCustomer_CustomerId(Long customerId);
}
