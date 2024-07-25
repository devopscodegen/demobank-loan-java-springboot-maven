package com.demobank.loan.domain.model.loan;

import org.jmolecules.ddd.annotation.Repository;

import com.demobank.loan.domain.model.common.BaseRepository;

@Repository
public interface LoanRepository extends BaseRepository<Loan, LoanNumber>{
    
}