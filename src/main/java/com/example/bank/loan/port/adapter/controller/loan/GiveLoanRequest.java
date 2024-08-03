package com.example.bank.loan.port.adapter.controller.loan;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class GiveLoanRequest {
    private BigInteger loanNumber;
    private String loanType;
    private BigInteger lenderAccountId;
    private BigDecimal amount;
    private String currencyCode;
}