package com.parcial.dos.parcialdos.account.dto;

import java.math.BigDecimal;

public class AccountRequestDTO {
    private String numeroCuenta;
    private String duenoCuenta;
    private BigDecimal balanceActual;

    public AccountRequestDTO() {}

    public AccountRequestDTO(String numeroCuenta, String duenoCuenta, BigDecimal balanceActual) {
        this.numeroCuenta = numeroCuenta;
        this.duenoCuenta = duenoCuenta;
        this.balanceActual = balanceActual;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getDuenoCuenta() {
        return duenoCuenta;
    }

    public void setDuenoCuenta(String duenoCuenta) {
        this.duenoCuenta = duenoCuenta;
    }

    public BigDecimal getBalanceActual() {
        return balanceActual;
    }

    public void setBalanceActual(BigDecimal balanceActual) {
        this.balanceActual = balanceActual;
    }
    
}
