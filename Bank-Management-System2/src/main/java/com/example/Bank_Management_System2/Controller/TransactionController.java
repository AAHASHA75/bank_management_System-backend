package com.example.Bank_Management_System2.Controller;

import com.example.Bank_Management_System2.Model.Transactions;
import com.example.Bank_Management_System2.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/accounts")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public String meassage(){
        return "Good";
    }

    @GetMapping("/transactions/{accountno}")
    public List<Transactions> allTransactions(@PathVariable Long accountno) {
        return transactionService.allTransactions(accountno);
    }

}
