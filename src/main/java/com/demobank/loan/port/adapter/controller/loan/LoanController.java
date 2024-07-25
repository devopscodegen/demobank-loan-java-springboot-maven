package com.demobank.loan.port.adapter.controller.loan;

import java.math.BigInteger;

import org.jmolecules.architecture.hexagonal.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demobank.loan.application.loan.GiveLoanCommand;
import com.demobank.loan.application.loan.LoanApplicationService;
import com.demobank.loan.domain.model.loan.Loan;

@RestController
@RequestMapping("/api/v1/loan")
@Adapter
public class LoanController {
    @Autowired
    private LoanApplicationService loanApplicationService;

    @PostMapping("/{loanNumber}")
    public GiveLoanResponse giveLoan(@PathVariable BigInteger loanNumber, @RequestBody GiveLoanRequest request) {
        Loan loan = this.loanApplicationService.giveLoan(
            new GiveLoanCommand(
                loanNumber,
                request.getLoanType(),
                request.getLenderAccountId(),
                request.getAmount(),
                request.getCurrencyCode()
            )
        );
        
        return new GiveLoanResponse(
            loan.getBorrowerAccountId().getId(),
            loan.getDisbursementId().getId(),
            "SUCCESS");
    }
}