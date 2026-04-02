package com.example.Bank_Management_System2.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    public String handleCustomerException(CustomerException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(AccountException.class)
    public String handleCustomerException(AccountException ex){ return ex.getMessage();}

    @ExceptionHandler(TransactionException.class)
    public String handleTransactionsException(TransactionException ex){ return ex.getMessage();}
}
