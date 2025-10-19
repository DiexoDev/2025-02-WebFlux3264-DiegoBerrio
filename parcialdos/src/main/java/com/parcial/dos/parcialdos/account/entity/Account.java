package com.parcial.dos.parcialdos.account.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String accountNumber;    
    private String ownerName;    
    private BigDecimal balance = BigDecimal.ZERO;   
    private Boolean active = true;

    public Account() {}

    public Account(String accountNumber, String ownerName, BigDecimal balance, Boolean active) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance == null ? BigDecimal.ZERO : balance;
        this.active = active == null ? true : active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public static Object builder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'builder'");
    }

    
    }
