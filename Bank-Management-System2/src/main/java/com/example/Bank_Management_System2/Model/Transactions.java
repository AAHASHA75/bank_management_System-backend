package com.example.Bank_Management_System2.Model;

import com.example.Bank_Management_System2.Enum.Transtype;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionid;

    @Column(nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Transtype transtype;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Account_no", nullable = false)
    private Account account;
}
