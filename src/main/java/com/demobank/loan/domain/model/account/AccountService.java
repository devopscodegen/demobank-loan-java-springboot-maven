package com.demobank.loan.domain.model.account;

import org.jmolecules.architecture.hexagonal.Port;
import org.jmolecules.ddd.annotation.Service;

import com.demobank.loan.domain.model.currency.CurrencyCode;

@Service
@Port
public interface AccountService {

    public void openAccount(AccountId accountId, AccountType accountType, CurrencyCode balanceCurrencyCode);
}
