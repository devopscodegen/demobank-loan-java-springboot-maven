package com.example.bank.loan.domain.model.account;

import org.jmolecules.architecture.hexagonal.Port;
import org.jmolecules.ddd.annotation.Service;

import com.example.bank.loan.domain.model.currency.CurrencyCode;

@Service
@Port
public interface AccountService {

    public void openAccount(AccountId accountId, AccountType accountType, CurrencyCode balanceCurrencyCode);
}
