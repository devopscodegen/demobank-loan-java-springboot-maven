package com.example.bank.loan.domain.model.loan;

import org.jmolecules.ddd.annotation.AggregateRoot;

import com.example.bank.loan.domain.model.account.AccountId;
import com.example.bank.loan.domain.model.common.BaseAggregateRoot;
import com.example.bank.loan.domain.model.money.Money;
import com.example.bank.loan.domain.model.transfer.TransferId;

import jakarta.annotation.Nullable;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="loans")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@ToString
@AggregateRoot
public class Loan extends BaseAggregateRoot<Loan, LoanNumber> {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private LoanNumber loanNumber;
    private LoanType loanType;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(
            name="id", 
            column=@jakarta.persistence.Column(name="lender_account_id"))
    })
    private AccountId lenderAccountId;
    @Embedded
    private Money amount;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(
            name="id", 
            column=@jakarta.persistence.Column(name="borrower_account_id"))
    })
    private AccountId borrowerAccountId;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(
            name="id", 
            column=@jakarta.persistence.Column(name="disbursement_id"))
    })
    private TransferId disbursementId;
    public Loan(LoanNumber loanNumber, LoanType loanType, AccountId lenderAccountId, Money amount, AccountId borrowerAccountId, TransferId transferId) {
        super();
        this.setLoanNumber(loanNumber);
        this.setLoanType(loanType);
        this.setLenderAccountId(lenderAccountId);
        this.setAmount(amount);
        this.setBorrowerAccountId(borrowerAccountId);
        this.setDisbursementId(transferId);
        registerEvent(new LoanGiven(this));
    }

    @Nullable
	@Override
	public LoanNumber getId() {
		return this.getLoanNumber();
	}
	@Transient
	@Override
	public boolean isNew() {
		return null == this.getId();
	}
}
