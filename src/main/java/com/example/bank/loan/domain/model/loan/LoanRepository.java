package com.example.bank.loan.domain.model.loan;

import org.jmolecules.ddd.annotation.Repository;

import com.example.bank.loan.domain.model.common.BaseRepository;

@Repository
public interface LoanRepository extends BaseRepository<Loan, LoanNumber>{
    
}