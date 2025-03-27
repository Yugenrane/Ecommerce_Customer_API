package com.example.Ecommerce_customer.restcontrollers;

import com.example.Ecommerce_customer.dto.CustomerRequestDTO;
import com.example.Ecommerce_customer.dto.LoginDTO;
import com.example.Ecommerce_customer.entities.Orders;
import com.example.Ecommerce_customer.services.LoginService;
import com.example.Ecommerce_customer.services.OrderDashboard;
import com.example.Ecommerce_customer.services.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final RegistrationService registrationService;
    private final LoginService loginService;
    private final OrderDashboard orderDashboard;
    public UserController(RegistrationService registrationService, LoginService loginService, OrderDashboard orderDashboard){
        this.registrationService=registrationService;
        this.loginService=loginService;
        this.orderDashboard=orderDashboard;
    }
    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody CustomerRequestDTO customerRequestDTO){
        String str= registrationService.registerUser(customerRequestDTO);
        return ResponseEntity.ok(str);
    }

    @PostMapping("/userLogin")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(loginService.login(loginDTO));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<List<Orders>> dashboard(@RequestParam Long customerId){
        return ResponseEntity.ok(orderDashboard.returnOrders(customerId));
    }
}
