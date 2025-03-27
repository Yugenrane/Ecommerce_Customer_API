package com.example.Ecommerce_customer.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;
    private String email;
    private String password;
    private String customerPhNo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private ShippingAddress shippingAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Orders> orders;
}
