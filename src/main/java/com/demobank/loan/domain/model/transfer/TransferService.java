package com.demobank.loan.domain.model.transfer;

import org.jmolecules.architecture.hexagonal.Port;
import org.jmolecules.ddd.annotation.Service;

import com.demobank.loan.domain.model.account.AccountId;
import com.demobank.loan.domain.model.money.Money;

@Service
@Port
public interface TransferService {

    public TransferId transferAmountBetweenAccounts(AccountId fromAccountId, AccountId toAccountId, Money amount);
}