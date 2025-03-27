package com.example.Ecommerce_customer.services;

import com.example.Ecommerce_customer.entities.Orders;
import com.example.Ecommerce_customer.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDashboard {
    private final OrderRepo orderRepo;
    public OrderDashboard(OrderRepo orderRepo){
        this.orderRepo=orderRepo;
    }
    public List<Orders> returnOrders(Long customerId){
        return orderRepo.findByCustomer_CustomerId(customerId);
    }
}
