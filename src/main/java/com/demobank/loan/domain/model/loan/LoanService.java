package com.demobank.loan.domain.model.loan;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demobank.loan.domain.model.account.AccountId;
import com.demobank.loan.domain.model.account.AccountService;
import com.demobank.loan.domain.model.account.AccountType;
import com.demobank.loan.domain.model.money.Money;
import com.demobank.loan.domain.model.transfer.TransferId;
import com.demobank.loan.domain.model.transfer.TransferService;

@Service
@org.jmolecules.ddd.annotation.Service
public class LoanService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransferService transferService;

    public Loan giveLoan(LoanNumber loanNumber, LoanType loanType, AccountId lenderAccountId, Money amount) {

        AccountId borrowerAccountId = new AccountId(
            loanNumber.getNumber()
            .add(
                BigInteger.valueOf(2000000)
            )
        );
        this.accountService.openAccount(
            borrowerAccountId,
            AccountType.valueOf("LOAN"),
            amount.getCurrencyCode()
        );
        TransferId transferId = this.transferService.transferAmountBetweenAccounts(
            lenderAccountId,
            borrowerAccountId,
            amount
        );
        Loan loan = new Loan(
            loanNumber,
            loanType,
            lenderAccountId,
            amount,
            borrowerAccountId,
            transferId
        );
        return loan;
    }
}
