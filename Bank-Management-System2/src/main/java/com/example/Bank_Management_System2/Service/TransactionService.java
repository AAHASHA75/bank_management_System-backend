package com.example.Bank_Management_System2.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bank_Management_System2.Model.Account;
import com.example.Bank_Management_System2.Model.Transactions;
import com.example.Bank_Management_System2.Enum.Transtype;
import com.example.Bank_Management_System2.Repository.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository ;

    //View All Transactions By Account Number
    public List<Transactions> allTransactions(Long accountno) {
         List<Transactions>  transactions = transactionRepository.findByAccountAccountNo(accountno);
         return transactions;
    }

    //Adding Deposit History
    public void depositeadd(Account account, BigDecimal amount) {
        Transactions transactions = new Transactions();
        transactions.setAccount(account);
        transactions.setAmount(amount);
        transactions.setDateTime(LocalDateTime.now());
        transactions.setTranstype(Transtype.DEPOSIT);
        transactionRepository.save(transactions);
    }

    //Adding Withdraw History
    public void withdraw(Account account, BigDecimal amount) {
        Transactions transactions = new Transactions();
        transactions.setAccount(account);
        transactions.setAmount(amount);
        transactions.setDateTime(LocalDateTime.now());
        transactions.setTranstype(Transtype.WITHDRAW);
        transactionRepository.save(transactions);
    }
}
