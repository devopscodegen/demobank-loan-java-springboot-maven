package com.example.bank.loan.domain.model.loan;

import java.util.Date;

import org.jmolecules.event.annotation.DomainEvent;

import com.example.bank.loan.domain.model.common.BaseDomainEvent;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@DomainEvent
public class LoanGiven extends BaseDomainEvent {
    private Loan loan;

    public LoanGiven(Loan loan) {
        super();
        this.setLoan(loan);
        this.setEventVersion(1);
        this.setOccurredOn(new Date());
        this.setEventType(this.getClass().getName());
    }
}
