package com.example.Ecommerce_customer.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    @OneToOne(mappedBy = "shippingAddress")
    private Customer customer;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private List<Orders> orders;
}
