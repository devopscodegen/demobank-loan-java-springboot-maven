package com.demobank.loan.port.adapter.controller.loan;

import java.math.BigInteger;
import java.util.UUID;

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
public class GiveLoanResponse {
    private BigInteger borrowerAccountId;
    private UUID disbursementId;
    private String status;
}