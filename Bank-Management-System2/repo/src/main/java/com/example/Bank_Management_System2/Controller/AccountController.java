package com.example.Bank_Management_System2.Controller;

import com.example.Bank_Management_System2.Model.Account;
import com.example.Bank_Management_System2.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin(origins = "*") // allow all origins for development
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{customerId}")
    public List<Account> findByCustomerId(@PathVariable Long customerId) {
        return accountService.findByCustomerId(customerId);
    }

    @PostMapping("/create/{customerId}")
    public String createAccount(@PathVariable Long customerId) {
        return accountService.createAccount(customerId);
    }

    @GetMapping("/balance/{accountno}")
    public BigDecimal accountbalance(@PathVariable Long accountno) {
        return accountService.accountbalance(accountno);
    }

    @PutMapping("/deposit/{accountno}/{amount}")
    public String deposite(@PathVariable Long accountno, @PathVariable BigDecimal amount) {
        return accountService.deposit(accountno, amount);
    }

    @PutMapping("/withdraw/{accountno}/{amount}")
    public String withdraw(@PathVariable Long accountno, @PathVariable BigDecimal amount) {
        return accountService.withdraw(accountno, amount);
    }
}
