package com.example.Bank_Management_System2.Controller;

import com.example.Bank_Management_System2.Model.Loginrequest;
import com.example.Bank_Management_System2.Service.CustomerService;
import com.example.Bank_Management_System2.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public String registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @PostMapping("/login")
    public String loginCustomer(@RequestBody Loginrequest loginrequest) {
        return customerService.loginCustomer(loginrequest.getEmail(), loginrequest.getPassword());
    }
}
