package com.example.Bank_Management_System2.Repository;

import com.example.Bank_Management_System2.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository  extends JpaRepository<Transactions, Long> {
    List<Transactions> findByAccountAccountNo(Long accountno);
}
