package com.demobank.loan.application.loan;

import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demobank.loan.domain.model.account.AccountId;
import com.demobank.loan.domain.model.currency.CurrencyCode;
import com.demobank.loan.domain.model.loan.Loan;
import com.demobank.loan.domain.model.loan.LoanNumber;
import com.demobank.loan.domain.model.loan.LoanRepository;
import com.demobank.loan.domain.model.loan.LoanService;
import com.demobank.loan.domain.model.loan.LoanType;
import com.demobank.loan.domain.model.money.Money;

@Service
@Application
public class LoanApplicationService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanService loanService;

    @Transactional
    public Loan giveLoan(GiveLoanCommand giveLoanCommand) {
        Loan loan = this.loanService.giveLoan(
            new LoanNumber(giveLoanCommand.getLoanNumber()),
            LoanType.valueOf(giveLoanCommand.getLoanType()),
            new AccountId(giveLoanCommand.getLenderAccountId()),
            new Money(
                giveLoanCommand.getAmount(),
                CurrencyCode.valueOf(giveLoanCommand.getCurrencyCode())
            )
        );
        
        loan = this.loanRepository.save(loan);

        return loan;
    }
}