package com.example.Ecommerce_customer.services;

import com.example.Ecommerce_customer.repositories.CustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class ForgetPasswordService {
    private final CustomerRepo customerRepo;

    public ForgetPasswordService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


}
