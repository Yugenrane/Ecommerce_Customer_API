package com.example.Ecommerce_customer.services;

import com.example.Ecommerce_customer.dto.CustomerRequestDTO;
import com.example.Ecommerce_customer.entities.Customer;
import com.example.Ecommerce_customer.entities.ShippingAddress;
import com.example.Ecommerce_customer.repositories.CustomerRepo;

import com.example.Ecommerce_customer.repositories.ShippingAddressRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {
    private final CustomerRepo customerRepo;
    private final ShippingAddressRepo shippingAddressRepo;
    public RegistrationService(CustomerRepo customerRepo, ShippingAddressRepo shippingAddressRepo){
        this.customerRepo=customerRepo;
        this.shippingAddressRepo=shippingAddressRepo;
    }
    public String registerUser(CustomerRequestDTO customerRequestDTO){
        Optional<Customer> customer=customerRepo.findByEmail(customerRequestDTO.getEmail());
        if(customer.isEmpty()){
            Customer user=new Customer();
            user.setCustomerName(customerRequestDTO.getCustomerName());
            user.setEmail(customerRequestDTO.getEmail());
            user.setPassword(customerRequestDTO.getPassword());
            user.setCustomerPhNo(customerRequestDTO.getCustomerPhNo());
            user.setShippingAddress(getShippingAddress(customerRequestDTO));
            customerRepo.save(user);
            shippingAddressRepo.save(getShippingAddress(customerRequestDTO));
        }else
            return "Account exist using "+customerRequestDTO.getEmail()+" email. Please login.";
        return "Customer registered Successfully.";
    }
    private static ShippingAddress getShippingAddress(CustomerRequestDTO customerRequestDTO) {
        ShippingAddress address = new ShippingAddress();
        address.setHouseNumber(customerRequestDTO.getShippingAddressDTO().getHouseNumber());
        address.setStreet(customerRequestDTO.getShippingAddressDTO().getStreet());
        address.setCity(customerRequestDTO.getShippingAddressDTO().getCity());
        address.setState(customerRequestDTO.getShippingAddressDTO().getState());
        address.setZipcode(customerRequestDTO.getShippingAddressDTO().getZipcode());
        address.setCountry(customerRequestDTO.getShippingAddressDTO().getCountry());
        return address;
    }
}
