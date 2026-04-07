package com.example.Bank_Management_System2.Service;

import com.example.Bank_Management_System2.Exception.AccountException;
import com.example.Bank_Management_System2.Model.Account;
import com.example.Bank_Management_System2.Model.Customer;
import com.example.Bank_Management_System2.Enum.Status;
import com.example.Bank_Management_System2.Repository.AccountRepository;
import com.example.Bank_Management_System2.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountRepository accountRepository;

    //Account Creating
    public String createAccount(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new AccountException("Customer not Found"));
        Account account = new Account();
        account.setCustomer(customer);
        account.setBalance(BigDecimal.ZERO);
        account.setStatus(Status.ACTIVE);
        accountRepository.save(account);
        return "Account Create Successfully";
    }

    // All Account
    public List<Account> findByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

    // Balance
    public BigDecimal accountbalance(Long accountno) {
        Account account = accountRepository.findById(accountno)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getStatus() == Status.ACTIVE) {
            return account.getBalance();
        } else if (account.getStatus() == Status.INACTIVE) {
            throw new AccountException("Account Inactive");
        } else {
            throw new AccountException("Account Blocked");
        }
    }

    // deposit
    public String deposit(Long accountno, BigDecimal amount) {
        Account account = accountRepository.findById(accountno)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getStatus() == Status.ACTIVE) {
            account.setBalance(account.getBalance().add(amount));
            transactionService.depositeadd(account, amount);
            accountRepository.save(account);
            return amount + " Credited Successfully! Current balance " + account.getBalance();
        } else if (account.getStatus() == Status.INACTIVE) {
            throw new AccountException("Account Inactive");
        } else {
            throw new AccountException("Account Blocked");
        }
    }


    // withdraw
    public String withdraw(Long accountno, BigDecimal amount) {
        Account account = accountRepository.findById(accountno)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getStatus() == Status.ACTIVE) {
            BigDecimal bal = account.getBalance();
            if (bal.compareTo(amount) == 1 || bal.compareTo(amount) == 0) {
                account.setBalance(account.getBalance().subtract(amount));
            } else if (bal.compareTo(amount) == -1) {
                throw new AccountException("" + "Insufficient balance"); }

                transactionService.withdraw(account, amount);
                accountRepository.save(account);
                return amount + " Debited Successfully! Current balance " + account.getBalance();
            } else if (account.getStatus() == Status.INACTIVE) {
                throw new AccountException("Account Inactive");
            } else {
                throw new AccountException("Account Blocked");
            }
        }
}



