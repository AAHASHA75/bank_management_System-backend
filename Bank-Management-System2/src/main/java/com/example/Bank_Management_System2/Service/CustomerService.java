package com.example.Bank_Management_System2.Service;

import com.example.Bank_Management_System2.Exception.CustomerException;
import com.example.Bank_Management_System2.Model.Customer;
import com.example.Bank_Management_System2.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    // Register
    public String registerCustomer(Customer customer) {
        try {
            customerRepository.save(customer);
            return "Successfully Registered";
        } catch (Exception e) {
            throw new CustomerException("Customer Registration Failed");
        }
    }

    // Login Customer
    public String loginCustomer(String email, String password) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new CustomerException("Invalid email"));
        if(!customer.getPassword().equals(password)) {
            throw new CustomerException("Invalid password");
        }
        return "Login Successful";
    }
}
