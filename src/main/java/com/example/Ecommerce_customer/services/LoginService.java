package com.example.Ecommerce_customer.services;

import com.example.Ecommerce_customer.dto.LoginDTO;
import com.example.Ecommerce_customer.entities.Customer;
import com.example.Ecommerce_customer.repositories.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    private final CustomerRepo customerRepo;

    public LoginService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    public String login(LoginDTO loginDTO){
        Optional<Customer> customer=customerRepo.findByEmail(loginDTO.getUsername());
        if(customer.isEmpty())
            return "User not registered. Please register first.....";
        else if(customer.get().getPassword().equals(loginDTO.getPassword()))
            return "User Successfully Login.....";
        else
            return "Password Incorrect. Please enter correct password.....";
    }
}
