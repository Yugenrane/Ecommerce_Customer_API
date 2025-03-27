package com.example.Ecommerce_customer.dto;

import lombok.Data;

@Data
public class CustomerRequestDTO {
    private String customerName;
    private String email;
    private String password;
    private String repeatPassword;
    private String customerPhNo;
    private ShippingAddressDTO shippingAddressDTO;
}
