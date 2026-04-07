package com.example.Bank_Management_System2.Service;

import com.example.Bank_Management_System2.Exception.CustomerException;
import com.example.Bank_Management_System2.Model.Account;
import com.example.Bank_Management_System2.Model.Admin;
import com.example.Bank_Management_System2.Model.Customer;
import com.example.Bank_Management_System2.Enum.Status;
import com.example.Bank_Management_System2.Repository.AccountRepository;
import com.example.Bank_Management_System2.Repository.AdminRepository;
import com.example.Bank_Management_System2.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AdminRepository adminRepository;

    // View All Customers
    public List<Customer> viewallcustomers() {
        return customerRepository.findAll();
    }

    // View All Accounts
    public List<Account> viewallaccounts() {
        return accountRepository.findAll();
    }

    //Block Account
    public String accountblock(Long accountno) {
        Account account = accountRepository.findById(accountno)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setStatus(Status.BLOCKED);
        accountRepository.save(account);

        return accountno+" Account Blocked";
    }

    //Unblock Account
    public String accountunblock(Long accountno) {
        Account account = accountRepository.findById(accountno)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setStatus(Status.ACTIVE);
        accountRepository.save(account);
        return accountno+" Account Activated";
    }

    //Inactive Account
    public String accountinactive(Long accountno) {
        Account account = accountRepository.findById(accountno)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setStatus(Status.INACTIVE);
        accountRepository.save(account);
        return accountno+" Account iNACTIVATED";
    }

    // Admin Login
    public String loginCustomer(String email, String password) {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new CustomerException("Invalid email"));
        if(!admin.getPassword().equals(password)) {
            throw new CustomerException("Invalid password");
        }
        return "Login Successful";
    }
}
